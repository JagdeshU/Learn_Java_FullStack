package io.jagdesh.Spring_CRUD_Mapstruct.exception;

import lombok.Data;

@Data
public class ResourceAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    public ResourceAlreadyExistsException(String message) {
        this.message = message;
    }

}
