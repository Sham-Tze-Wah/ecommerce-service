package com.sham.ecommerceservice.serviceimpl;

import com.sham.ecommerceservice.dto.ProductResponse;
import com.sham.ecommerceservice.entity.Product;
import com.sham.ecommerceservice.dto.ProductFilterParam;
import com.sham.ecommerceservice.dto.ProductDTO;
import com.sham.ecommerceservice.repository.ProductRepo;
import com.sham.ecommerceservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Product createProduct(ProductDTO productRequest, MultipartFile[] files){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());

        if(ArrayUtils.isNotEmpty(files)) {
            for (MultipartFile file : files) {
                //move files to S3 Bucket
                //Then get the url and save into db
            }
        }

        Product savedProduct = productRepo.save(product);
        log.info("Product {} is saved", savedProduct.getName());
        return savedProduct;
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepo.findAll();
        List<ProductResponse> productsResponse =
                products.stream()
                        .map(product -> mapToProductResponse(product))
                        .collect(Collectors.toList());
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
        log.info("product start price filtering: {}",productFilterParam.startPrice());
        return null;
    }
}
