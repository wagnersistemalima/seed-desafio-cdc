package com.sistemalima.casadocodigodeveficiente.adapters.controller.state.service;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.exceptions.BussinessException;
import com.sistemalima.casadocodigodeveficiente.application.ports.input.StateService;
import com.sistemalima.casadocodigodeveficiente.domain.State;
import com.sistemalima.casadocodigodeveficiente.repository.country.entity.CountryEntity;
import com.sistemalima.casadocodigodeveficiente.repository.state.StateRepository;
import com.sistemalima.casadocodigodeveficiente.repository.state.entity.StateEntity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public State create(State state, Long countryId) {

        CountryEntity countryEntity = entityManager.find(CountryEntity.class, countryId);

        if (countryEntity == null) {
            throw new BussinessException("Voce esta tentando cadastrar um estado para um pais que nao existe  idPais: " + countryId);
        }

        StateEntity stateEntity = state.toEntity(countryEntity);

        stateRepository.save(stateEntity);

        State stateCopySave = stateEntity.toDomain();

        return stateCopySave;
    }
}
