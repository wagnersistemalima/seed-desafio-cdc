package com.sistemalima.casadocodigodeveficiente.adapters.controller.book;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.book.entity.BookRequest;
import com.sistemalima.casadocodigodeveficiente.adapters.controller.book.entity.BookResponse;
import com.sistemalima.casadocodigodeveficiente.adapters.controller.entity.DefaultResponse;
import com.sistemalima.casadocodigodeveficiente.domain.ports.input.BookService;
import com.sistemalima.casadocodigodeveficiente.domain.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<DefaultResponse<BookResponse>> create(
            @Valid @RequestBody BookRequest bookRequest
    ) {
        Book book = bookService.create(bookRequest.toDomain(), bookRequest.getIdCategory(), bookRequest.getIdAuthor());
        return ResponseEntity.ok(new DefaultResponse<>(book.toResponse()));
    }
}
