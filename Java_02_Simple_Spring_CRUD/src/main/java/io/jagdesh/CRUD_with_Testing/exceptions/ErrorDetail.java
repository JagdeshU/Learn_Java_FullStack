package io.jagdesh.CRUD_with_Testing.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorDetail {

    private Date timestamp;
    private String message;
    private String detail;

    //  Constructor for GlobalExceptionHandler
    public ErrorDetail(Date date, String message, String description) {}

}
