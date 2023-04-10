package io.jagdesh.Spring_CRUD_Mapstruct.service;

import io.jagdesh.Spring_CRUD_Mapstruct.entity.Commerce;

import java.util.List;

public interface CommerceService {

    public Commerce save(Commerce commerce);
    public List<Commerce> findAll();
    public Commerce findOne(Integer id);
    public Commerce update(Integer id, Commerce commerce);
    public void delete(Integer id);

}
