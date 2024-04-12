package com.sistemalima.casadocodigodeveficiente.repository.category;

import com.sistemalima.casadocodigodeveficiente.repository.category.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
}
