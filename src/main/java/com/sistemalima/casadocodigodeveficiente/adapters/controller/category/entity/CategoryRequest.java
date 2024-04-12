package com.sistemalima.casadocodigodeveficiente.adapters.controller.category.entity;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.validation.UniqueValue;
import com.sistemalima.casadocodigodeveficiente.domain.Category;
import com.sistemalima.casadocodigodeveficiente.repository.category.entity.CategoryEntity;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class CategoryRequest implements Serializable {

    @NotBlank
    @UniqueValue(domainClass = CategoryEntity.class, fieldName = "name")
    private String name;

    public CategoryRequest() {
    }

    public CategoryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category toDomain() {
        return new Category(
                name = this.getName()
        );
    }
}
