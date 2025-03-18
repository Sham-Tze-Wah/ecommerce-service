package com.sham.ecommerceservice.repository;

import com.sham.ecommerceservice.entity.Account;
import com.sham.ecommerceservice.entity.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface PermissionsRepo extends JpaRepository<Permissions, UUID> {
    Set<Permissions> getRolesByName(String name);
}
