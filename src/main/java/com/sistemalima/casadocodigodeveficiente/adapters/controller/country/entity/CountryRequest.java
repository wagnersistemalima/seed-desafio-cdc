package com.sistemalima.casadocodigodeveficiente.adapters.controller.country.entity;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.validation.UniqueValue;
import com.sistemalima.casadocodigodeveficiente.domain.Country;
import com.sistemalima.casadocodigodeveficiente.repository.country.entity.CountryEntity;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class CountryRequest implements Serializable {

    @NotBlank
    @UniqueValue(domainClass = CountryEntity.class, fieldName = "name", message = "validação nome do Pais deve ser unico")
    private String name;

    @Deprecated
    public CountryRequest(){
    }

    public CountryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country toDomain() {
        return new Country(
                name = this.getName()
        );
    }
}
