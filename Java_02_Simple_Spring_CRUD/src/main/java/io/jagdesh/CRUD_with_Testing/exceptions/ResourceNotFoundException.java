package io.jagdesh.CRUD_with_Testing.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundException(String employee, String id, Long id1) {
    }
}
