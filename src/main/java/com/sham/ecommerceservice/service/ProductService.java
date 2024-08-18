package com.sham.ecommerceservice.service;

import com.sham.ecommerceservice.dto.ProductResponse;
import com.sham.ecommerceservice.entity.Product;
import com.sham.ecommerceservice.pojo.ProductFilterParam;
import com.sham.ecommerceservice.pojo.ProductPojo;
import com.sham.ecommerceservice.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {



    @Autowired
    private ProductRepo productRepo;

    public void createProduct(ProductPojo productRequest){
        Product product = Product.builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepo.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepo.findAll();
        List<ProductResponse> productsResponse = products.stream().map(product -> mapToProductResponse(product)).collect(Collectors.toList());
        return productsResponse;
    }

    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public List<ProductResponse> getAllProducts(ProductFilterParam productFilterParam) {
        return null;
    }
}
