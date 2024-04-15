package com.sistemalima.casadocodigodeveficiente.domain.ports.input;

import com.sistemalima.casadocodigodeveficiente.domain.Book;

public interface BookService {

    Book create(Book book, Long idCategory, Long idAuthor);
}
