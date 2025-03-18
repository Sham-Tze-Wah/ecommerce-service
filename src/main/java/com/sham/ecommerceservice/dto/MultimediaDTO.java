package com.sham.ecommerceservice.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class MultimediaDTO {
    private String id;
    private String url;
    private String mediaName;
    private String mediaType;
    private BigInteger fileSize;
    private String productId;
    private byte[] idk;
}
