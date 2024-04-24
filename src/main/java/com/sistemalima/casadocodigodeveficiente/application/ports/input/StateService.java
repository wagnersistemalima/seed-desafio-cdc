package com.sistemalima.casadocodigodeveficiente.application.ports.input;

import com.sistemalima.casadocodigodeveficiente.domain.State;

public interface StateService {

    State create(State state, Long countryId);
}
