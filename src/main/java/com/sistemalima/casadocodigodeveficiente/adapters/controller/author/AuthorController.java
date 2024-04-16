package com.sistemalima.casadocodigodeveficiente.adapters.controller.author;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.author.entity.AuthorRequest;
import com.sistemalima.casadocodigodeveficiente.adapters.controller.entity.DefaultResponse;
import com.sistemalima.casadocodigodeveficiente.adapters.controller.validation.ProibeEmailDuplucadoValidation;
import com.sistemalima.casadocodigodeveficiente.application.ports.input.AuthorService;
import com.sistemalima.casadocodigodeveficiente.domain.Author;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/autores")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private ProibeEmailDuplucadoValidation proibeEmailDuplucadoValidation;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeEmailDuplucadoValidation);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse<Author>> novoAutor(
            @Valid @RequestBody AuthorRequest authorRequest
    ) {
        Author author = authorService.create(authorRequest.toDomain());
        return ResponseEntity.ok(new DefaultResponse<>(author));
    }
}
