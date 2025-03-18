package com.sham.ecommerceservice.exception;

/*
 *
 *  Author: Sham Tze Wah
 *  Source: https://www.twilio.com/en-us/blog/media-file-storage-java-spring-boot-amazon-s3-buckets
 * /
 */


public class SpringBootFileUploadException extends Exception{
    public SpringBootFileUploadException(String message) {
        super(message);
    }
}
