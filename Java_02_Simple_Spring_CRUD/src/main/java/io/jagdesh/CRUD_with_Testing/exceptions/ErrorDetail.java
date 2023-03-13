package io.jagdesh.CRUD_with_Testing.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorDetail {

    private Date timestamp;
    private String message;
    private String detail;

    //  Constructor for GlobalExceptionHandler, mapping response body for the exceptions
    public ErrorDetail(Date date, String message, String description) {
        this.timestamp = date;
        this.message = message;
        this.detail = description;
    }

}
