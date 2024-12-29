package com.sham.ecommerceservice.entity;

import com.sham.ecommerceservice.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data //made up of @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode
@EqualsAndHashCode(callSuper = true, exclude = {"rolesSet"})
@Entity
@Table(name="account")
public abstract class Account extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "hashed_pwd")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private String phoneNo;

    //Address in future
    @ManyToMany
    @JoinTable(
            name="account_roles",
            joinColumns = @JoinColumn,
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Roles> rolesSet;
}
