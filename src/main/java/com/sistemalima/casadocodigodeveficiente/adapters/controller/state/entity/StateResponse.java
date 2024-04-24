package com.sistemalima.casadocodigodeveficiente.adapters.controller.state.entity;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.country.entity.CountryResponse;
import com.sistemalima.casadocodigodeveficiente.domain.Country;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StateResponse implements Serializable {

    private Long id;

    private String name;

    private CountryResponse countryResponse;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    @Deprecated
    public StateResponse() {
    }

    public StateResponse(Long id, String name, CountryResponse countryResponse, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.countryResponse = countryResponse;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CountryResponse getCountryResponse() {
        return countryResponse;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }
}
