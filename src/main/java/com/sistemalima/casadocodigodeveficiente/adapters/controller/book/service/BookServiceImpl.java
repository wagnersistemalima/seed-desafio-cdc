package com.sistemalima.casadocodigodeveficiente.adapters.controller.book.service;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.ResourceNotFoundException;
import com.sistemalima.casadocodigodeveficiente.domain.ports.input.BookService;
import com.sistemalima.casadocodigodeveficiente.domain.Book;
import com.sistemalima.casadocodigodeveficiente.repository.author.AuthorRepository;
import com.sistemalima.casadocodigodeveficiente.repository.author.entity.AuthorEntity;
import com.sistemalima.casadocodigodeveficiente.repository.book.BookRepository;
import com.sistemalima.casadocodigodeveficiente.repository.category.CategoryRepository;
import com.sistemalima.casadocodigodeveficiente.repository.category.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AuthorRepository authorRepository;


    @Transactional
    @Override
    public Book create(Book book, Long idCategory, Long idAuthor) {

        CategoryEntity anCategoryEntity = findCategoryEntity(idCategory);

        AuthorEntity anAuthorEntity = findAuthorEntity(idAuthor);

        return bookRepository.save(book.toEntity(anCategoryEntity, anAuthorEntity)).toDomain();
    }

    @Transactional(readOnly = true)
    private CategoryEntity findCategoryEntity(Long idCategory) {
        return categoryRepository.findById(idCategory).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado idCategory: " + idCategory)
        );
    }

    @Transactional(readOnly = true)
    private AuthorEntity findAuthorEntity(Long idAuthor) {
        return authorRepository.findById(idAuthor).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado idAuthor: " + idAuthor)
        );
    }
}
