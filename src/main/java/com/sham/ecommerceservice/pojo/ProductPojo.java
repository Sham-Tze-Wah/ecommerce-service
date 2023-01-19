package com.sham.ecommerceservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPojo {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String description;
    private BigDecimal price;
}
