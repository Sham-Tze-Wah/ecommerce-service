package com.sham.ecommerceservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true, exclude = {"rolesSet"})
@Entity
@Table(name="permissions")
@NoArgsConstructor
public class Permissions extends BaseEntity implements Serializable {
    @Column(name = "name")
    private String name;
//    private String value;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "roles_permissions",
            joinColumns = @JoinColumn,
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Roles> rolesSet;
}
