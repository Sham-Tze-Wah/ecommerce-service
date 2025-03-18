package com.sham.ecommerceservice.service;

import com.sham.ecommerceservice.entity.Promotion;

import java.util.List;

public interface PromotionService {
    Promotion savePromotionRecord(Promotion promotion);
    List<Promotion> saveAllPromotions(List<Promotion> promotions);
    List<Promotion> getAllPromotions();
    void deletePromotions(String id);
}
