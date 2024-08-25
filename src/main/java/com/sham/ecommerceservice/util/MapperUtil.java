package com.sham.ecommerceservice.util;

public record MapperUtil(Object from, Object to) {
    void Mapper{
        System.out.println(from);
        System.out.println(to);
    }
}
