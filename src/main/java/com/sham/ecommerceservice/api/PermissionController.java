package com.sham.ecommerceservice.api;

//import com.sham.ecommerceservice.dto.PermissionsDTO;
import com.sham.ecommerceservice.dto.PermissionsRecord;
import com.sham.ecommerceservice.entity.Permissions;
import com.sham.ecommerceservice.service.PermissionsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/permission")
public class PermissionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private final MessageSource messageSource;

    @Autowired
    private PermissionsService permissionsService;

    @PostMapping("/post")
    public ResponseEntity<?> createNewPermission(@RequestBody PermissionsRecord permissionsRecord) {
        try {
            Permissions permissions = permissionsService.createPermission(permissionsRecord);
            if (Objects.nonNull(permissions)) {
                return new ResponseEntity<>(messageSource.getMessage("permissions.create.success",
                        new Object[]{
                                Objects.nonNull(permissionsRecord) ? permissionsRecord.name() : null
                        },
                        Locale.ENGLISH), HttpStatus.CREATED);
            } else {
                throw new Exception("Permission creation failed");
            }
        } catch (DuplicateKeyException e) {
            LOGGER.error("Exception in createNewPermission API: {}", e);
            return new ResponseEntity<>(
                    messageSource.getMessage("permissions.duplicate.name",
                            new Object[]{
                                    Objects.nonNull(permissionsRecord) ? permissionsRecord.name() : null
                            },
                            Locale.ENGLISH),
                    HttpStatus.UNPROCESSABLE_ENTITY);

        } catch (Exception e) {
            LOGGER.error("Exception in createNewPermission API: {}", e);
            return new ResponseEntity<>(
                    messageSource.getMessage("permissions.create.invalid",
                            new Object[]{
                                    Objects.nonNull(permissionsRecord) ? permissionsRecord.name() : null
                            },
                            Locale.ENGLISH),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllPermission() {
        return new ResponseEntity<>(permissionsService.getAllPermissions(), HttpStatus.OK);
    }
}
