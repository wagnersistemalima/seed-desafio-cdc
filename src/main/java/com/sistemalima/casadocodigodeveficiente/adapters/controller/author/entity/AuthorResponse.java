package com.sistemalima.casadocodigodeveficiente.adapters.controller.author.entity;

import java.time.LocalDateTime;

public class AuthorResponse {

    private Long id;

    private String name;

    private String email;

    private String description;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    public AuthorResponse() {
    }

    public AuthorResponse(Long id, String name, String email, String description, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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