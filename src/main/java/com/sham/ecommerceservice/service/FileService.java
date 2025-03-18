/*
 *
 *  Author: Sham Tze Wah
 *  Source: https://www.twilio.com/en-us/blog/media-file-storage-java-spring-boot-amazon-s3-buckets
 * /
 */

package com.sham.ecommerceservice.service;

import com.sham.ecommerceservice.exception.FileDownloadException;
import com.sham.ecommerceservice.exception.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/*
 *
 *  Author: Sham Tze Wah
 *  Source: https://www.twilio.com/en-us/blog/media-file-storage-java-spring-boot-amazon-s3-buckets
 * /
 */


public interface FileService {
    String uploadFile(MultipartFile multipartFile) throws FileUploadException, IOException;

    Object downloadFile(String fileName) throws FileDownloadException, IOException;

    boolean delete(String fileName);
}
