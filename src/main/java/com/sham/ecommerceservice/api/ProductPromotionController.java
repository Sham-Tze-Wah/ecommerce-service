package com.sham.ecommerceservice.api;

import com.sham.ecommerceservice.entity.Promotion;
import com.sham.ecommerceservice.service.PromotionService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class ProductPromotionController {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ProductPromotionController.class);

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private MessageSource messageSource;

    @PostMapping
    public ResponseEntity<?> addPromotion(Promotion promotion) {
        try {
            Promotion savedPromotionRecord = promotionService.savePromotionRecord(promotion);
            return new ResponseEntity<>(savedPromotionRecord, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(
                    messageSource.getMessage("promotion.create.invalid", null, Locale.ENGLISH),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping
    public ResponseEntity<?> getPromotions() {
        try {
            List<Promotion> promotions = promotionService.getAllPromotions();
            return new ResponseEntity<>(promotions, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(
                    messageSource.getMessage("promotion.get.invalid", null, Locale.ENGLISH),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deletePromotion(@PathVariable("id") String id) {
        try {
            promotionService.deletePromotions(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Exception in : {}", ex.getMessage());
            return new ResponseEntity<>(
                    messageSource.getMessage("promotion.delete.invalid", null, Locale.ENGLISH),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
