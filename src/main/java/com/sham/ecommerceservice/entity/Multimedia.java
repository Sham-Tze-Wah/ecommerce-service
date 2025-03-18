package com.sham.ecommerceservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="multimedia")
@NoArgsConstructor
public class Multimedia extends BaseEntity implements Serializable {

    @Column(name = "url")
    @NonNull
    private String url;

    @Column(name = "media_type")
    @NonNull
    private String mediaType;

    @Column(name = "file_size")
    private BigInteger fileSize = BigInteger.valueOf(0);

    @Column(name = "media_name")
    @NonNull
    private String mediaName;

}
