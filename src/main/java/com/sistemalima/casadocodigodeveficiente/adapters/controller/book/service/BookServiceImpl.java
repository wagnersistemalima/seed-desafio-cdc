package com.sistemalima.casadocodigodeveficiente.adapters.controller.book.service;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.exceptions.BussinessException;
import com.sistemalima.casadocodigodeveficiente.adapters.controller.exceptions.ResourceNotFoundException;
import com.sistemalima.casadocodigodeveficiente.application.ports.input.BookService;
import com.sistemalima.casadocodigodeveficiente.domain.Book;
import com.sistemalima.casadocodigodeveficiente.repository.author.entity.AuthorEntity;
import com.sistemalima.casadocodigodeveficiente.repository.book.BookRepository;
import com.sistemalima.casadocodigodeveficiente.repository.book.entity.BookEntity;
import com.sistemalima.casadocodigodeveficiente.repository.category.entity.CategoryEntity;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookServiceImpl implements BookService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;


    @Transactional
    @Override
    public Book create(Book book, Long idCategory, Long idAuthor) {

        CategoryEntity anCategoryEntity = findCategoryEntity(idCategory);

        AuthorEntity anAuthorEntity = findAuthorEntity(idAuthor);

        return bookRepository.save(book.toEntity(anCategoryEntity, anAuthorEntity)).toDomain();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> fundAll() {
        List<BookEntity> listEntity = (List<BookEntity>) bookRepository.findAll();
        return listEntity.stream().map(Book::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public Book findById(Long id) {

        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado idBook: " + id)
        );
        return bookEntity.toDomain();
    }

    private CategoryEntity findCategoryEntity(Long idCategory) {
        @NotNull CategoryEntity categoryEntity = entityManager.find(CategoryEntity.class, idCategory);

        if (categoryEntity == null) {
             throw new BussinessException("Voce esta tentando cadastrar um livro que não tem idCategoria " + idCategory);
        }

        return categoryEntity;
    }

    private AuthorEntity findAuthorEntity(Long idAuthor) {
        @NotNull AuthorEntity authorEntity = entityManager.find(AuthorEntity.class, idAuthor);

        if (authorEntity == null) {
            throw new BussinessException("Voce esta tentando cadastrar um livro que não tem idAuthor " + idAuthor);
        }
        return authorEntity;
    }
}
