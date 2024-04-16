package com.sistemalima.casadocodigodeveficiente.repository.country.entity;

import com.sistemalima.casadocodigodeveficiente.domain.Country;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_country")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Deprecated
    public CountryEntity() {
    }

    public CountryEntity(Long id, String name) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryEntity that = (CountryEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public Country toDomain() {
        return new Country(
                id = this.getId(),
                name = this.getName()
        );
    }
}
