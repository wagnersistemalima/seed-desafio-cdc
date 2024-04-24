package com.sistemalima.casadocodigodeveficiente.adapters.controller.state.entity;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.validation.UniqueValue;
import com.sistemalima.casadocodigodeveficiente.domain.State;
import com.sistemalima.casadocodigodeveficiente.repository.state.entity.StateEntity;
import jakarta.validation.constraints.NotBlank;

public class StateRequest {

    @NotBlank
    @UniqueValue(domainClass = StateEntity.class, fieldName = "name")
    private String name;

    private Long countryId;

    @Deprecated
    public StateRequest() {
    }

    public StateRequest(String name, Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public State toDomain() {
        return new State(
              name = this.getName()
        );
    }
}
