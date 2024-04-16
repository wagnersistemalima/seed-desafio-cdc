package com.sistemalima.casadocodigodeveficiente.domain;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.book.entity.BookResponse;
import com.sistemalima.casadocodigodeveficiente.repository.author.entity.AuthorEntity;
import com.sistemalima.casadocodigodeveficiente.repository.book.entity.BookEntity;
import com.sistemalima.casadocodigodeveficiente.repository.category.entity.CategoryEntity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Book {

    private Long id;

    private String title;

    private String summedUp;

    private String summary;

    private BigDecimal price;

    private Integer page;

    private String isbn;

    private LocalDate publicationDate;

    private Category category;

    private Author author;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    @Deprecated
    public Book() {
    }

    public Book(Long id, String title, String summedUp, String summary, BigDecimal price, Integer page, String isbn, LocalDate publicationDate, Category category, Author author, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.title = title;
        this.summedUp = summedUp;
        this.summary = summary;
        this.price = price;
        this.page = page;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.category = category;
        this.author = author;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Book(String title, String summedUp, String summary, BigDecimal price, Integer page, String isbn, LocalDate publicationDate, Category category, Author author) {
        this.title = title;
        this.summedUp = summedUp;
        this.summary = summary;
        this.price = price;
        this.page = page;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.category = category;
        this.author = author;
    }

    public Book(BookEntity bookEntity) {
        this.id = bookEntity.getId();
        this.title = bookEntity.getTitle();
        this.summedUp = bookEntity.getSummedUp();
        this.summary = bookEntity.getSummary();
        this.price = bookEntity.getPrice();
        this.page = bookEntity.getPage();
        this.isbn = bookEntity.getIsbn();
        this.publicationDate = bookEntity.getPublicationDate();
        this.category = bookEntity.getCategory().toDomain();
        this.author = bookEntity.getAuthor().toDomain();
        this.createAt = bookEntity.getCreatAt();
        this.updateAt = bookEntity.getUpdateAt();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummedUp() {
        return summedUp;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getPage() {
        return page;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public BookEntity toEntity(CategoryEntity anCategoryEntity, AuthorEntity anAuthorEntity) {

        return new BookEntity(
                id = this.getId(),
                title = this.getTitle(),
                summedUp = this.getSummedUp(),
                summary = this.getSummary(),
                price = this.getPrice(),
                page = this.getPage(),
                isbn = this.getIsbn(),
                publicationDate = this.getPublicationDate(),
                anCategoryEntity,
                anAuthorEntity,
                createAt = this.getCreateAt(),
                updateAt = this.getUpdateAt()
        );
    }

    public BookResponse toResponse() {

        return new BookResponse(
                id = this.getId(),
                title = this.getTitle(),
                summedUp = this.getSummedUp(),
                summary = this.getSummary(),
                price = this.getPrice(),
                page = this.getPage(),
                isbn = this.getIsbn(),
                publicationDate = this.getPublicationDate(),
                category = this.getCategory(),
                author = this.getAuthor(),
                createAt = this.getCreateAt(),
                updateAt = this.getUpdateAt()
        );
    }
}
