package com.sham.ecommerceservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
Record is used when:
Immutable is required which means a class has only constructor and getter methods and no setter methods
or any other behavioral methods
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AccountRecord() {
}
