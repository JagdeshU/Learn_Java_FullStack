package io.jagdesh.Spring_CRUD_Mapstruct.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "commerce")
public class Commerce {

    @Id
    private Integer id;
    private String name;
    private String price;
    private String promotionCode;
    private String refId;
    private Integer quantity;

}
