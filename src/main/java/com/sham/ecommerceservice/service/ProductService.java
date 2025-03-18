package com.sham.ecommerceservice.service;

import com.sham.ecommerceservice.dto.ProductResponse;
import com.sham.ecommerceservice.entity.Product;
import com.sham.ecommerceservice.dto.ProductFilterParam;
import com.sham.ecommerceservice.dto.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ProductService {

    Product createProduct(ProductDTO productRequest, MultipartFile[] files);

    List<ProductResponse> getAllProducts();

    List<ProductResponse> getAllProducts(ProductFilterParam productFilterParam);
}
