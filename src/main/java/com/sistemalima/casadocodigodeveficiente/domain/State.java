package com.sistemalima.casadocodigodeveficiente.domain;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.state.entity.StateResponse;
import com.sistemalima.casadocodigodeveficiente.repository.country.entity.CountryEntity;
import com.sistemalima.casadocodigodeveficiente.repository.state.entity.StateEntity;

import java.time.LocalDateTime;

public class State {

    private Long id;

    private String name;

    private Country country;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    @Deprecated
    public State() {
    }

    public State(Long id, String name, Country country, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public State(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public StateEntity toEntity(CountryEntity countryEntity) {
        return new StateEntity(
                id = this.getId(),
                name = this.getName(),
                countryEntity,
                createAt = this.getCreateAt(),
                updateAt = this.getUpdateAt()
        );
    }

    public StateResponse toResponse() {
        return new StateResponse(
                id = this.getId(),
                name = this.getName(),
                this.getCountry().toResponse(),
                createAt = this.getCreateAt(),
                updateAt = this.getUpdateAt()
        );
    }
}
