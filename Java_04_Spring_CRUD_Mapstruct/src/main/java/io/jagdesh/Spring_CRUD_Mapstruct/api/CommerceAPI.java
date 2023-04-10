package io.jagdesh.Spring_CRUD_Mapstruct.api;

import io.jagdesh.Spring_CRUD_Mapstruct.dto.CommerceDto;
import io.jagdesh.Spring_CRUD_Mapstruct.entity.Commerce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CommerceAPI {

    @PostMapping("/")
    public void save(@RequestBody CommerceDto dto);

    @GetMapping("/")
    public List<CommerceDto> findAll();

    @GetMapping("/{id}")
    public CommerceDto findOne(@PathVariable("id") int id);

    @PutMapping("/{id}")
    public CommerceDto update(@PathVariable("id") int id, @RequestBody Commerce commerce);

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCommerceById(@PathVariable("id") Integer id);

}
