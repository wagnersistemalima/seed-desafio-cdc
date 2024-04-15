package com.sistemalima.casadocodigodeveficiente.repository.book;

import com.sistemalima.casadocodigodeveficiente.repository.book.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
