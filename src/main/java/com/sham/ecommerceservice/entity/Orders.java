package com.sham.ecommerceservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true, exclude = {"orderLines"})
@Entity
@Table(name="orders")
@NoArgsConstructor
public class Orders extends BaseEntity implements Serializable {
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime orderDate;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "shipped_addr")
    private String shippingAddress;

    @Column(name = "shipped_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime shippedDate;

    @Column(name = "total_price", precision = 12, scale = 2)
    private BigDecimal totalPrice = BigDecimal.ZERO;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="shipping_option_id")
    private ShippingOption shippingOption;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private List<OrderLine> orderLines;
}
