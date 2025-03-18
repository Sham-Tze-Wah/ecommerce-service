package com.sham.ecommerceservice.entity;

import com.sham.ecommerceservice.constant.SqlDataType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true, exclude = {"orders"})
@Entity
@Table(name="shipping_option")
@NoArgsConstructor
public class ShippingOption extends BaseEntity implements Serializable {
    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "code", length = SqlDataType.VARCHAR10)
    @NonNull
    private String code;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "shippingOption", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Orders> orders;
}
