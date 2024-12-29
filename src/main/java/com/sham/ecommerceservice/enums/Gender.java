package com.sham.ecommerceservice.enums;

import lombok.Getter;

@Getter
public enum Gender {
    MALE("MALE"), FEMALE("FEMALE"), PREFER_NOT_TO_SAY("PREFER_NOT_TO_SAY");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public static Gender getGenderEnum(String value) {
        for (Gender gender : Gender.values()) {
            if (gender.value.equalsIgnoreCase(value)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("No enum constant for value: " + value);
    }
}
