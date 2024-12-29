package com.sham.ecommerceservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="multimedia")
public class Multimedia extends BaseEntity implements Serializable {

    @Column(name = "url")
    @NonNull
    private String url;

    @Column(name = "media_type")
    @NonNull
    private String mediaType;

    @Column(name = "file_size")
    private int fileSize = 0;

    @Column(name = "media_name")
    @NonNull
    private String mediaName;

}
