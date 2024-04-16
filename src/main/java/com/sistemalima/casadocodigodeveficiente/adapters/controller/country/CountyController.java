package com.sistemalima.casadocodigodeveficiente.adapters.controller.country;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.country.entity.CountryRequest;
import com.sistemalima.casadocodigodeveficiente.adapters.controller.country.entity.CountryResponse;
import com.sistemalima.casadocodigodeveficiente.adapters.controller.entity.DefaultResponse;
import com.sistemalima.casadocodigodeveficiente.application.ports.input.CountryService;
import com.sistemalima.casadocodigodeveficiente.domain.Country;
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
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/pais")
public class CountyController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public ResponseEntity<DefaultResponse<CountryResponse>> create(
            @Valid @RequestBody CountryRequest countryRequest
    ) {
        Country country = countryService.create(countryRequest.toDomain());

        return ResponseEntity.ok(new DefaultResponse<>(country.toResponse()));
    }
}
