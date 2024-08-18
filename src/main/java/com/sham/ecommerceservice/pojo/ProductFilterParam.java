package com.sham.ecommerceservice.pojo;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class ProductFilterParam {
    private String name;
    private String startPrice;
    private String endPrice;
    private String category;
    private String brand;
    private Double rating;
}
