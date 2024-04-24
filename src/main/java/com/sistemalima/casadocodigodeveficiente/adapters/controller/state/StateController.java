package com.sistemalima.casadocodigodeveficiente.adapters.controller.state;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.entity.DefaultResponse;
import com.sistemalima.casadocodigodeveficiente.adapters.controller.state.entity.StateRequest;
import com.sistemalima.casadocodigodeveficiente.adapters.controller.state.entity.StateResponse;
import com.sistemalima.casadocodigodeveficiente.application.ports.input.StateService;
import com.sistemalima.casadocodigodeveficiente.domain.State;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @PostMapping
    public ResponseEntity<DefaultResponse<StateResponse>> create(
            @Valid @RequestBody StateRequest stateRequest
    ) {
        State state = stateService.create(stateRequest.toDomain(), stateRequest.getCountryId());
        return ResponseEntity.ok(new DefaultResponse(state.toResponse()));
    }
}
