package com.sham.ecommerceservice.api;

import com.sham.ecommerceservice.dto.ProductResponse;
import com.sham.ecommerceservice.pojo.ProductFilterParam;
import com.sham.ecommerceservice.pojo.ProductPojo;
import com.sham.ecommerceservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private final MessageSource messageSource;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductPojo productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProductResponse(){
        return productService.getAllProducts();
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String startPrice,
            @RequestParam(required = false) String endPrice,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Double rating
            ){
        try{
            ProductFilterParam productFilterParam = new ProductFilterParam();
            productFilterParam.setName(name);
            productFilterParam.setStartPrice(startPrice);
            productFilterParam.setEndPrice(endPrice);
            productFilterParam.setCategory(category);
            productFilterParam.setBrand(brand);
            productFilterParam.setRating(rating);
            return new ResponseEntity<>(
                    productService.getAllProducts(productFilterParam),
                    HttpStatus.OK
            );
        }
        catch(Exception ex){
            return new ResponseEntity<>(
                    messageSource.getMessage("product.invalid", null, Locale.ENGLISH),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
