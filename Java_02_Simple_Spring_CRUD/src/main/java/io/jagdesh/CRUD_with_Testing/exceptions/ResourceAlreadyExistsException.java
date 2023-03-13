package io.jagdesh.CRUD_with_Testing.exceptions;

import lombok.Data;

@Data
public class ResourceAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String resourceName;
    private String fieldName;
    private String fieldValue;

}
