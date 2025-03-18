package com.sham.ecommerceservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true, exclude = {"accounts", "permissions"})
@Entity
@Table(name="roles")
@NoArgsConstructor
public class Roles extends BaseEntity implements Serializable {
    @Column(name = "name", unique = true)
    @NonNull
    private String name; //

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "rolesSet", fetch = FetchType.LAZY)
    private Set<Account> accounts;

    @ManyToMany(mappedBy = "rolesSet", fetch = FetchType.LAZY)
    private Set<Permissions> permissions;
}
