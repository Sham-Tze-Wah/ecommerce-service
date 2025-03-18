package com.sham.ecommerceservice.serviceimpl.mapper;

//import com.sham.ecommerceservice.dto.RolesDTO;
import com.sham.ecommerceservice.dto.RolesRecord;
import com.sham.ecommerceservice.entity.Roles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
@Slf4j
public class RolesMapper {
    public Roles mapRolesDTOToRolesEntity(RolesRecord rolesRecord) {
        Roles roles = new Roles();
        if (StringUtils.hasText(rolesRecord.id())) {
            roles.setId(UUID.fromString(rolesRecord.id()));
        } else {
            roles.setId(UUID.randomUUID());
        }
        roles.setName(rolesRecord.name());
        roles.setDescription(rolesRecord.description());
        return roles;
    }

    public RolesRecord mapRolesEntityToRolesDTO(Roles roles) {
        RolesRecord rolesDTO = new RolesRecord(roles.getId().toString(), roles.getName(), roles.getDescription());
        return rolesDTO;
    }
}
