package com.sham.ecommerceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private List<MultimediaDTO> multimediaDTOList;
}
