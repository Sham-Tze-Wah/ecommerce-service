package com.sham.ecommerceservice.serviceimpl;

//import com.sham.ecommerceservice.dto.PermissionsDTO;
import com.sham.ecommerceservice.dto.PermissionsRecord;
import com.sham.ecommerceservice.entity.Permissions;
import com.sham.ecommerceservice.repository.PermissionsRepo;
import com.sham.ecommerceservice.service.PermissionsService;
import com.sham.ecommerceservice.serviceimpl.mapper.PermissionsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class PermissionsServiceImpl implements PermissionsService {

    @Autowired
    private final MessageSource messageSource;

    @Autowired
    private PermissionsMapper permissionsMapper;

    @Autowired
    private PermissionsRepo permissionsRepo;

    @Override
    public Permissions createPermission(PermissionsRecord permissionsRecord) {
        //business logic
        if (!StringUtils.hasText(permissionsRecord.name())) {
            log.error(messageSource.getMessage("permissions.name.empty", null, Locale.ENGLISH));
            return null;
        }

        if (!CollectionUtils.isEmpty(permissionsRepo.getRolesByName(permissionsRecord.name()))) {
//            log.error(messageSource.getMessage("permissions.duplicate.name", new Object[]{permissionsRecord.name()}, Locale.ENGLISH));
            throw new DuplicateKeyException(messageSource.getMessage("permissions.duplicate.name", new Object[]{permissionsRecord.name()}, Locale.ENGLISH));
        }

        //mapper
        Permissions permissions = permissionsMapper.mapPermissionsRecordToEntity(permissionsRecord);
        Permissions savedPermissions = permissionsRepo.save(permissions);
        return savedPermissions;
    }

    @Override
    public Set<PermissionsRecord> getAllPermissions() {
        Set<Permissions> permissionsSet = new HashSet<>(permissionsRepo.findAll());
        Set<PermissionsRecord> permissionsRecordsSet = new HashSet<>(permissionsSet.size());
        for (Permissions permissions : permissionsSet) {
            permissionsRecordsSet.add(permissionsMapper.mapPermissionsEntityToRecord(permissions));
        }
        return permissionsRecordsSet;
    }
}
