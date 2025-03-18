package com.sham.ecommerceservice.serviceimpl;

import com.sham.ecommerceservice.entity.Promotion;
import com.sham.ecommerceservice.repository.PromotionRepo;
import com.sham.ecommerceservice.service.PromotionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    private PromotionRepo promotionRepo;

    @Override
    public Promotion savePromotionRecord(Promotion promotion) {
        return promotionRepo.save(promotion);
    }

    @Override
    public List<Promotion> saveAllPromotions(List<Promotion> promotions) {
        return promotionRepo.saveAll(promotions);
    }

    @Override
    public List<Promotion> getAllPromotions() {
        return promotionRepo.findAll();
    }

    @Override
    public void deletePromotions(String id) {
        promotionRepo.deleteById(UUID.fromString(id));
    }
}

