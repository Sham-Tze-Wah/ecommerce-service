package com.sham.ecommerceservice.api;

import com.sham.ecommerceservice.dto.ProductResponse;
import com.sham.ecommerceservice.dto.ProductFilterParam;
import com.sham.ecommerceservice.dto.ProductDTO;
import com.sham.ecommerceservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private final MessageSource messageSource;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDTO productRequest,
                              @RequestParam("mediaFiles") MultipartFile[] files){
        productService.createProduct(productRequest, files);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProductResponse(){
        return productService.getAllProducts();
    }

    @GetMapping("/products")
    public ResponseEntity<?> getFilteredProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double startPrice,
            @RequestParam(required = false) Double endPrice,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Double rating
            ){
        try{
            ProductFilterParam productFilterParam = new ProductFilterParam(
                    name,
                    startPrice,
                    endPrice,
                    category,
                    brand,
                    rating
            );
            return new ResponseEntity<>(
                    productService.getAllProducts(productFilterParam),
                    HttpStatus.OK
            );
        }
        catch(Exception ex){
            LOGGER.error("Exception in getFilteredProducts API: {}", ex);
            return new ResponseEntity<>(
                    messageSource.getMessage("product.invalid", null, Locale.ENGLISH),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
