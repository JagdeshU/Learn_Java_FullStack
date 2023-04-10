package io.jagdesh.Spring_CRUD_Mapstruct.controller;

import io.jagdesh.Spring_CRUD_Mapstruct.api.CommerceAPI;
import io.jagdesh.Spring_CRUD_Mapstruct.dto.CommerceDto;
import io.jagdesh.Spring_CRUD_Mapstruct.entity.Commerce;
import io.jagdesh.Spring_CRUD_Mapstruct.mapper.CommerceMapper;
import io.jagdesh.Spring_CRUD_Mapstruct.service.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/commerce")
public class CommerceController implements CommerceAPI {

    @Autowired
    private CommerceService commerceService;

    @Autowired
    private CommerceMapper commerceMapper;

    @Override
    public void save(CommerceDto dto) {
        Commerce commerce = commerceMapper.dtoToModel(dto);
        commerceService.save(commerce);
    }

    @Override
    public List<CommerceDto> findAll() {
        return commerceMapper.modelsToDtos(commerceService.findAll());
    }

    @Override
    public CommerceDto findOne(int id) {
        return commerceMapper.modelToDto(commerceService.findOne(id));
    }

    @Override
    public CommerceDto update(int id, Commerce commerce) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteCommerceById(Integer id) {
        return null;
    }
}
