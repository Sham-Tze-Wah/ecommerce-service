package com.sham.ecommerceservice.serviceimpl.mapper;

import com.sham.ecommerceservice.dto.ProductDTO;
//import com.sham.ecommerceservice.dto.RolesDTO;
import com.sham.ecommerceservice.entity.Product;
import com.sham.ecommerceservice.entity.Roles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class ProductMapper {
    public Product mapProductDTOToProductEntity(ProductDTO productDTO) {
        Product product = new Product();
        if (StringUtils.hasText(productDTO.getId())) {
            product.setId(UUID.fromString(productDTO.getId()));
        } else {
            product.setId(UUID.randomUUID());
        }
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
        return product;
    }

    public ProductDTO mapProductEntityToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        if (Objects.nonNull(product.getId())) {
            productDTO.setId(product.getId().toString());
        }
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }
}
