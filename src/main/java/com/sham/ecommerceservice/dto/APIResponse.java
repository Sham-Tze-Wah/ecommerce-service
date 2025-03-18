/*
 *
 *  Author: Sham Tze Wah
 *  Source: https://www.twilio.com/en-us/blog/media-file-storage-java-spring-boot-amazon-s3-buckets
 * /
 */

package com.sham.ecommerceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/*
 *
 *  Author: Sham Tze Wah
 *  Source: https://www.twilio.com/en-us/blog/media-file-storage-java-spring-boot-amazon-s3-buckets
 * /
 */

@AllArgsConstructor
@Data
@Builder
public class APIResponse {
    private String message;
    private boolean isSuccessful;
    private int statusCode;
    private Object data;
}
