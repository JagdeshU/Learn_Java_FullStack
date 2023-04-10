package io.jagdesh.Spring_CRUD_Mapstruct.service.impl;

import io.jagdesh.Spring_CRUD_Mapstruct.entity.Commerce;
import io.jagdesh.Spring_CRUD_Mapstruct.exception.ResourceAlreadyExistsException;
import io.jagdesh.Spring_CRUD_Mapstruct.exception.ResourceNotFoundException;
import io.jagdesh.Spring_CRUD_Mapstruct.repository.CommerceRepository;
import io.jagdesh.Spring_CRUD_Mapstruct.service.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommerceServiceImpl implements CommerceService {

    private CommerceRepository comRepo;

    @Autowired
    public CommerceServiceImpl(CommerceRepository comRepo) {
        this.comRepo = comRepo;
    }

    @Override
    public Commerce save(Commerce commerce) {
        Optional<Commerce> optionalCommerce = comRepo.findByRefId(commerce.getRefId());
        if (optionalCommerce.isPresent()) {
            throw new ResourceAlreadyExistsException("Data already present");
        }
        return comRepo.save(commerce);
    }

    @Override
    public List<Commerce> findAll() {
        return comRepo.findAll();
    }

    @Override
    public Commerce findOne(Integer id) {
        return comRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Requested details is not present with this ID : " + id));
    }

    @Override
    public Commerce update(Integer id, Commerce commerce) {
        return comRepo.findById(id)
                .map(e -> {
                    e.setName(commerce.getName());
                    e.setPrice(commerce.getPrice());
                    e.setPromotionCode(commerce.getPromotionCode());
                    e.setRefId(commerce.getRefId());
                    e.setQuantity(commerce.getQuantity());
                    return comRepo.save(e);
                })
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Requested details is not present with this ID : " + id));
    }

    @Override
    public void delete(Integer id) {
        Commerce foundCommerce = comRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Requested details is not present with this ID : " + id));
        comRepo.delete(foundCommerce);
    }

}
