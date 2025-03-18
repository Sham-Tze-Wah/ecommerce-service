package com.sham.ecommerceservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sham.ecommerceservice.constant.SqlDataType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true, exclude = {"orderLines", "promotions"})
@Entity
@Table(name="product")
@NoArgsConstructor
public class Product extends BaseEntity implements Serializable {

    @Column(name = "name", length = SqlDataType.VARCHAR2000)
    @NonNull
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", precision = 12, scale = 2)
    @NonNull
    private BigDecimal price = BigDecimal.ZERO;

    @Column(name = "quantity", columnDefinition = "INTEGER DEFAULT 0")
    private int quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private List<OrderLine> orderLines;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private List<Promotion> promotions;
}
