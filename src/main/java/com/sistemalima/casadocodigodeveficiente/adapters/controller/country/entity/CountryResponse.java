package com.sistemalima.casadocodigodeveficiente.adapters.controller.country.entity;

import com.sistemalima.casadocodigodeveficiente.domain.Country;

import java.io.Serializable;

public class CountryResponse implements Serializable {

    private Long id;

    private String name;

    @Deprecated
    public CountryResponse() {
    }

    public CountryResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CountryResponse(Country country) {
        id = country.getId();
        name = country.getName();
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
}
