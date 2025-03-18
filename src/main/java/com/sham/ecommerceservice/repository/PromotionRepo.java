package com.sham.ecommerceservice.repository;

import com.sham.ecommerceservice.entity.Promotion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Slf4j
public interface PromotionRepo extends JpaRepository<Promotion, UUID> {

}
