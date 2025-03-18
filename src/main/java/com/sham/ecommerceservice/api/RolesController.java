package com.sham.ecommerceservice.api;

import com.sham.ecommerceservice.dto.ProductDTO;
import com.sham.ecommerceservice.dto.ProductResponse;
//import com.sham.ecommerceservice.dto.RolesDTO;
import com.sham.ecommerceservice.dto.RolesRecord;
import com.sham.ecommerceservice.entity.Roles;
import com.sham.ecommerceservice.service.RolesService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/role")
public class RolesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    private final MessageSource messageSource;

    @Autowired
    private RolesService rolesService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createRole(@RequestBody RolesRecord rolesRecord){
        try {
            Roles roles = rolesService.createRole(rolesRecord);
            if (Objects.nonNull(roles)) {
                return new ResponseEntity<>(messageSource.getMessage("roles.create.success",
                        new Object[]{
                                Objects.nonNull(rolesRecord) ? rolesRecord.name() : null
                        },
                        Locale.ENGLISH), HttpStatus.CREATED);
            } else {
                throw new Exception("Role creation failed");
            }

        } catch (DuplicateKeyException e) {
            LOGGER.error("Exception in createRole API: {}", e);
            return new ResponseEntity<>(
                    messageSource.getMessage("roles.duplicate.name",
                            new Object[]{
                                    Objects.nonNull(rolesRecord) ? rolesRecord.name() : null
                            },
                            Locale.ENGLISH),
                    HttpStatus.UNPROCESSABLE_ENTITY);

        } catch (Exception e) {
            LOGGER.error("Exception in createRole API: {}", e);
            return new ResponseEntity<>(
                    messageSource.getMessage("roles.create.invalid",
                            new Object[]{
                                    Objects.nonNull(rolesRecord) ? rolesRecord.name() : null
                            },
                            Locale.ENGLISH),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getProductResponse(){
        return new ResponseEntity<>(rolesService.getAllRoles(), HttpStatus.OK);
    }
}
