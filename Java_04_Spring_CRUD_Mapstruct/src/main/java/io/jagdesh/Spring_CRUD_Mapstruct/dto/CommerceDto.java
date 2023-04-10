package io.jagdesh.Spring_CRUD_Mapstruct.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommerceDto {

    @Id
    private Integer id;
    private String name;
    private String price;
    private String code;
    private String refId;
    private String quantity;

}
