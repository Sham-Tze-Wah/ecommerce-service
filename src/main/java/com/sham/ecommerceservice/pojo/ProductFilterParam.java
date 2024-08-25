package com.sham.ecommerceservice.pojo;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

public record ProductFilterParam(String name, Double startPrice, Double endPrice, String category, String brand, Double rating) {

    public ProductFilterParam(String name, Double startPrice, Double endPrice, String category, String brand, Double rating){
        this.name = name;
        this.startPrice = startPrice;
        this.endPrice = endPrice;
        this.category = category;
        this.brand = brand;
        this.rating = rating;
    }


}
