/*
 *
 *  Author: Sham Tze Wah
 *  Source: https://www.twilio.com/en-us/blog/media-file-storage-java-spring-boot-amazon-s3-buckets
 * /
 */

package com.sham.ecommerceservice.exception;

/*
 *
 *  Author: Sham Tze Wah
 *  Source: https://www.twilio.com/en-us/blog/media-file-storage-java-spring-boot-amazon-s3-buckets
 * /
 */


public class FileUploadException extends SpringBootFileUploadException{

    public FileUploadException(String message) {
        super(message);
    }
}
