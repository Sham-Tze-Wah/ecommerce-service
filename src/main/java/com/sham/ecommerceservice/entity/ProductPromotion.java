/*
 *
 *  Author: Sham Tze Wah
 *  Source: https://www.twilio.com/en-us/blog/media-file-storage-java-spring-boot-amazon-s3-buckets
 * /
 */

package com.sham.ecommerceservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "PRODUCT_PROMOTION")
@Data
//@EqualsAndHashCode(callSuper = true, exclude = {})
public class ProductPromotion {
    //Product
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    //Promotion
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    //
}
