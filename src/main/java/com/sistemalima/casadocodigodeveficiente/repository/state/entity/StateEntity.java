package com.sistemalima.casadocodigodeveficiente.repository.state.entity;

import com.sistemalima.casadocodigodeveficiente.domain.State;
import com.sistemalima.casadocodigodeveficiente.repository.country.entity.CountryEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_state")
public class StateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    // relação um ou mais estados pertence a um pais
    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity countryEntity;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Deprecated
    public StateEntity() {
    }

    public StateEntity(Long id, String name, CountryEntity countryEntity, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.countryEntity = countryEntity;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CountryEntity getCountryEntity() {
        return countryEntity;
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

    public void setCountry(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateEntity stateEntity = (StateEntity) o;
        return Objects.equals(getId(), stateEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @PrePersist
    public void prePersiste() {
        this.createAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updateAt = LocalDateTime.now();
    }

    public State toDomain() {
        return new State(
                id = this.getId(),
                name = this.getName(),
                getCountryEntity().toDomain(),
                createAt = this.getCreateAt(),
                updateAt = this.getUpdateAt()
        );
    }
}
