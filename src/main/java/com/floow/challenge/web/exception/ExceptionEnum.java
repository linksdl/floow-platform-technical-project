package com.floow.challenge.web.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ExceptionEnum {

    INVALID_DATA_FORMAT_ERROR("100000", "Invalid data format"),
    DTDA_CREATE_ERROR("200000", "Failed to create the driver"),
    DTDA_QUERY_ERROR ("200001", "Failed to query the driver");

    private String code;

    private String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
