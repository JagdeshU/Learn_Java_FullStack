package io.jagdesh.Spring_CRUD_Mapstruct.repository;

import io.jagdesh.Spring_CRUD_Mapstruct.entity.Commerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommerceRepository extends JpaRepository<Commerce, Integer> {

    Optional<Commerce> findByRefId(String refId);

}
