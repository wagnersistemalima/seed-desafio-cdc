package com.sistemalima.casadocodigodeveficiente.adapters.controller.book;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.book.entity.BookRequest;
import com.sistemalima.casadocodigodeveficiente.adapters.controller.book.entity.BookResponse;
import com.sistemalima.casadocodigodeveficiente.adapters.controller.entity.DefaultResponse;
import com.sistemalima.casadocodigodeveficiente.application.ports.input.BookService;
import com.sistemalima.casadocodigodeveficiente.domain.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<DefaultResponse<List<BookResponse>>> findAll() {
        List<Book> listBook = bookService.fundAll();
        return ResponseEntity.ok(new DefaultResponse<>(listBook.stream().map(BookResponse::new).collect(Collectors.toList())));
    }

    @GetMapping("/{id}")
    ResponseEntity<DefaultResponse<BookResponse>> findById(
            @PathVariable("id") Long id)
    {
        Book book = bookService.findById(id);
        return ResponseEntity.ok(new DefaultResponse<>(book.toResponse()));
    }
}
