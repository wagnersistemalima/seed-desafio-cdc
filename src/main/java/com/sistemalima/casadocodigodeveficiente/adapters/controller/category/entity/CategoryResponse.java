package com.sistemalima.casadocodigodeveficiente.adapters.controller.category.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CategoryResponse implements Serializable {

    private Long id;

    private String name;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    public CategoryResponse() {
    }

    public CategoryResponse(Long id, String name, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
        this.updateAt = updateAt;
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

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
