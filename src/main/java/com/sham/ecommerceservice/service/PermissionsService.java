package com.sham.ecommerceservice.service;

//import com.sham.ecommerceservice.dto.PermissionsDTO;
import com.sham.ecommerceservice.dto.PermissionsRecord;
import com.sham.ecommerceservice.entity.Permissions;

import java.util.Set;

public interface PermissionsService {

    public Permissions createPermission(PermissionsRecord permissionsRecord);

    public Set<PermissionsRecord> getAllPermissions();
}
