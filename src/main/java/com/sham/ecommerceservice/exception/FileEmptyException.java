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


public class FileEmptyException extends SpringBootFileUploadException {
    public FileEmptyException(String message) {
        super(message);
    }
}
