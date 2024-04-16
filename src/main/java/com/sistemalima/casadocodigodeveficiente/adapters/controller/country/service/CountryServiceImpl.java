package com.sistemalima.casadocodigodeveficiente.adapters.controller.country.service;

import com.sistemalima.casadocodigodeveficiente.application.ports.input.CountryService;
import com.sistemalima.casadocodigodeveficiente.domain.Country;
import com.sistemalima.casadocodigodeveficiente.repository.country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;


    @Override
    public Country create(Country country) {
        return countryRepository.save(country.toEntity()).toDomain();
    }
}
