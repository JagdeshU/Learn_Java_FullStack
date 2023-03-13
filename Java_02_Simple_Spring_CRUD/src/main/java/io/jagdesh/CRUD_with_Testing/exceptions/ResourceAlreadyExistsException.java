package io.jagdesh.CRUD_with_Testing.exceptions;

import lombok.Data;

@Data
public class ResourceAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    public ResourceAlreadyExistsException(String message) {
        this.message = message;
    }
}
