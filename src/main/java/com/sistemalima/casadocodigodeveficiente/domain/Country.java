package com.sistemalima.casadocodigodeveficiente.domain;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.country.entity.CountryResponse;
import com.sistemalima.casadocodigodeveficiente.repository.country.entity.CountryEntity;

public class Country {

    private Long id;

    private String name;

    @Deprecated
    public Country() {
    }

    public Country(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Country(String name) {
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

    public CountryEntity toEntity() {
        return new CountryEntity(
                name = this.getName()
        );
    }

    public CountryResponse toResponse() {
        return new CountryResponse(
                id = this.getId(),
                name = this.getName()
        );
    }
}
