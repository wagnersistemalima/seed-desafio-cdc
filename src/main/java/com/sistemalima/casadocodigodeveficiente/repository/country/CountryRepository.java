package com.sistemalima.casadocodigodeveficiente.repository.country;

import com.sistemalima.casadocodigodeveficiente.repository.country.entity.CountryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<CountryEntity, Long> {
}
