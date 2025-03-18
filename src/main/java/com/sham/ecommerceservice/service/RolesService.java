package com.sham.ecommerceservice.service;

import com.sham.ecommerceservice.dto.RolesRecord;
import com.sham.ecommerceservice.entity.Roles;

import java.util.Set;

public interface RolesService {
    Roles createRole(RolesRecord rolesRecord);
    Set<RolesRecord> getAllRoles();
}
