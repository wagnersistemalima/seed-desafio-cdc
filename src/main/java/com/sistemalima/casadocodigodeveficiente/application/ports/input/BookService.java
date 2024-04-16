package com.sistemalima.casadocodigodeveficiente.application.ports.input;

import com.sistemalima.casadocodigodeveficiente.domain.Book;

import java.util.List;

public interface BookService {

    Book create(Book book, Long idCategory, Long idAuthor);

    List<Book> fundAll();

    Book findById(Long id);
}
