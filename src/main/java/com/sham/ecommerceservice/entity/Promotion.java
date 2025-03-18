package com.sham.ecommerceservice.entity;

import com.sham.ecommerceservice.constant.SqlDataType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name="promotion")
@Entity
@Data
public class Promotion extends BaseEntity implements Serializable {
    @Column(name = "name", length = SqlDataType.VARCHAR2000)
    @NonNull
    private String name;

    @Column(name = "value")
    private String value;

    @Column(name = "PROMO_EFF_DATE")
    private LocalDateTime promoEffectiveDate;

    @Column(name = "remarks")
    private String promoRemarks;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;
}
