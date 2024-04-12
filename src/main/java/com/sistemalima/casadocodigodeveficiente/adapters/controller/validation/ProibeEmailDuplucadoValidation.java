package com.sistemalima.casadocodigodeveficiente.adapters.controller.validation;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.author.entity.AuthorRequest;
import com.sistemalima.casadocodigodeveficiente.repository.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmailDuplucadoValidation implements Validator {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AuthorRequest.class.isAssignableFrom(clazz);
    }

    @Transactional(readOnly = true)
    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors()) {
            return;
        }

        AuthorRequest authorRequest = (AuthorRequest) target;

        if (authorRepository.findByEmail(authorRequest.getEmail()).isPresent()) {
            errors.rejectValue("email", "400",
                    "Já existe esse email em nosso cadastro " + authorRequest.getEmail());
        }

    }
}
