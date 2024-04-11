package com.sistemalima.casadocodigodeveficiente.adapters.controller.autor;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/autores")
public class AutorController {

    @GetMapping
    public String novoAutor() {
        return "novo autor cadastrado com sucesso";
    }
}
