package com.sistemalima.casadocodigodeveficiente.adapters.controller.author.entity;

import com.sistemalima.casadocodigodeveficiente.domain.Author;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

public class AuthorRequest implements Serializable {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Length(min = 1, max = 400)
    private String description;

    public AuthorRequest() {
    }

    public AuthorRequest(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author toDomain() {
        return new Author(
            this.getName(),
            this.getEmail(),
            this.getDescription()
        );
    }
}
