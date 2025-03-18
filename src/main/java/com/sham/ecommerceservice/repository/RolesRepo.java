package com.sham.ecommerceservice.repository;

import com.sham.ecommerceservice.entity.Product;
import com.sham.ecommerceservice.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface RolesRepo extends JpaRepository<Roles, UUID> {
    Set<Roles> getRolesByName(String name);
}
