package com.sham.ecommerceservice.serviceimpl;

//import com.sham.ecommerceservice.dto.RolesDTO;
import com.sham.ecommerceservice.dto.RolesRecord;
import com.sham.ecommerceservice.entity.Roles;
import com.sham.ecommerceservice.repository.RolesRepo;
import com.sham.ecommerceservice.service.RolesService;
import com.sham.ecommerceservice.serviceimpl.mapper.RolesMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesRepo rolesRepo;

    @Autowired
    private RolesMapper rolesMapper;

    @Autowired
    private final MessageSource messageSource;

    public Roles createRole(RolesRecord rolesRecord) throws RuntimeException {
        //business logic to create roles
        if (!StringUtils.hasText(rolesRecord.name())) {
            log.error(messageSource.getMessage("roles.name.empty", null, Locale.ENGLISH));
            return null;
        }

        if (!CollectionUtils.isEmpty(rolesRepo.getRolesByName(rolesRecord.name()))) {
//            log.error(messageSource.getMessage("roles.duplicate.name", new Object[]{rolesRecord.name()}, Locale.ENGLISH));
            throw new DuplicateKeyException(messageSource.getMessage("roles.duplicate.name", new Object[]{rolesRecord.name()}, Locale.ENGLISH));
        }

        //mapper function
        Roles roles = rolesMapper.mapRolesDTOToRolesEntity(rolesRecord);
        return rolesRepo.save(roles);
    }


    public Set<RolesRecord> getAllRoles() {
        Set<RolesRecord> rolesRecordSet = new HashSet<>();
        Set<Roles> rolesSet = new HashSet<>(rolesRepo.findAll());
        for (Roles roles : rolesSet) {
            rolesRecordSet.add(rolesMapper.mapRolesEntityToRolesDTO(roles));
        }
        return rolesRecordSet;
    }
}
