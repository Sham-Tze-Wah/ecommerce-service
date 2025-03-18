package com.sham.ecommerceservice.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MultimediaFileDTO {
    private String id;
    private MultipartFile file;
}
