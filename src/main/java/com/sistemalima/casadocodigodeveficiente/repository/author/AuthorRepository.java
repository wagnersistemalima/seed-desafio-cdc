package com.sistemalima.casadocodigodeveficiente.repository.author;

import com.sistemalima.casadocodigodeveficiente.repository.author.entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
    Optional<AuthorEntity> findByEmail(String email);
}
