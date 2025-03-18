package com.sham.ecommerceservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductFilterParam(
        @JsonProperty("name") String name,
        @JsonProperty("startPrice") Double startPrice,
        @JsonProperty("endPrice") Double endPrice,
        @JsonProperty("category") String category,
        @JsonProperty("brand") String brand,
        @JsonProperty("rating") Double rating) {

//    public ProductFilterParam(String name, Double startPrice, Double endPrice, String category, String brand, Double rating){
//        this.name = name;
//        this.startPrice = startPrice;
//        this.endPrice = endPrice;
//        this.category = category;
//        this.brand = brand;
//        this.rating = rating;
//    }


}
