package com.sham.ecommerceservice.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass // to enable embedding of its properties in the concrete subclass tables.
@EntityListeners(AuditingEntityListener.class) //  listens to lifecycle events (e.g., insert, update) of the entity and populates audit-related fields like creation time, last modified time, created by, and modified by.
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;

    //@CreationTimestamp //precise, database-managed timestamp. For database auditing or when working with Hibernate directly.
    @CreatedDate // When using Spring Data JPA for auditing. logical dates managed by the application, independent of the database.
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "deleted")
    private boolean deleted = false;

    @PrePersist
    public void onCreate() {
        this.createdDate = LocalDateTime.now();
    }


    @PostUpdate
    public void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }

}
