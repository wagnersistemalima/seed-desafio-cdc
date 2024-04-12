package com.sistemalima.casadocodigodeveficiente.adapters.controller.author.service;

import com.sistemalima.casadocodigodeveficiente.application.ports.input.AuthorService;
import com.sistemalima.casadocodigodeveficiente.domain.Author;
import com.sistemalima.casadocodigodeveficiente.repository.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    @Override
    public Author create(Author author) {

        return authorRepository.save(author.toEntity()).toDomain();

    }
}
