package com.sham.ecommerceservice.serviceimpl.mapper;

import com.sham.ecommerceservice.dto.PermissionsRecord;
import com.sham.ecommerceservice.entity.Permissions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
@Slf4j
public class PermissionsMapper {

    public Permissions mapPermissionsRecordToEntity(PermissionsRecord permissionsRecord) {
        Permissions permissions = new Permissions();
        if (StringUtils.hasText(permissionsRecord.id())) {
            permissions.setId(UUID.fromString(permissionsRecord.id()));
        } else {
            permissions.setId(UUID.randomUUID());
        }
        permissions.setName(permissionsRecord.name());
        permissions.setDescription(permissionsRecord.description());
        return permissions;
    }

    public PermissionsRecord mapPermissionsEntityToRecord(Permissions permissions) {
        return new PermissionsRecord(permissions.getId().toString(), permissions.getName(), permissions.getDescription());
    }

}
