package com.sham.ecommerceservice.entity;

import com.sham.ecommerceservice.constant.SqlDataType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @Column(name = "id")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id = UUID.randomUUID().toString();

    @Column(name = "name", nullable = false, length = SqlDataType.VARCHAR2000)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;
}
