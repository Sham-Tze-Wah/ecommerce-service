package com.sham.ecommerceservice.api;

import com.sham.ecommerceservice.dto.ProductResponse;
import com.sham.ecommerceservice.pojo.ProductPojo;
import com.sham.ecommerceservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

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
}
