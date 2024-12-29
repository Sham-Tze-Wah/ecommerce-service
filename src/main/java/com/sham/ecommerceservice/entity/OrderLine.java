package com.sham.ecommerceservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "order_line")
public class OrderLine extends BaseEntity implements Serializable {

    @Column(name = "order_qty", columnDefinition = "INT DEFAULT 0")
    private int orderQty;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "orders_id")
    private Orders orders;
}
