package com.sistemalima.casadocodigodeveficiente.repository.author.entity;

import com.sistemalima.casadocodigodeveficiente.domain.Author;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String description;

    private LocalDateTime createAt;

    public AuthorEntity() {
    }

    public AuthorEntity(Long id, String name, String email, String description, LocalDateTime createAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
        this.createAt = createAt;
    }

    public AuthorEntity(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEntity that = (AuthorEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail());
    }

    @PrePersist
    public void prePersiste() {
        createAt = LocalDateTime.now();
    }

    public Author toDomain() {
        return new Author(
             this.getId(),
             this.getName(),
             this.getEmail(),
             this.getDescription(),
             this.getCreateAt()
        );
    }
}
