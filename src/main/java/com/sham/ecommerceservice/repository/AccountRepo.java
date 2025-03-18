package com.sham.ecommerceservice.repository;

import com.sham.ecommerceservice.entity.Account;
import com.sham.ecommerceservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepo extends JpaRepository<Account, UUID> {
}
