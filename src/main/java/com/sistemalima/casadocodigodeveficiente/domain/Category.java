package com.sistemalima.casadocodigodeveficiente.domain;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.category.entity.CategoryResponse;
import com.sistemalima.casadocodigodeveficiente.repository.category.entity.CategoryEntity;

import java.time.LocalDateTime;

public class Category {

    private Long id;

    private String name;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    public Category(){
    }

    public Category(Long id, String name, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public CategoryEntity toEntity() {
        return new CategoryEntity(
                id = this.getId(),
                name = this.getName(),
                createAt = this.getCreateAt(),
                updateAt = this.getUpdateAt()
        );
    }

    public CategoryResponse toResponse() {
        return new CategoryResponse(
            id = this.getId(),
            name = this.getName(),
            createAt = this.getCreateAt(),
            updateAt = this.getUpdateAt()
        );
    }
}
