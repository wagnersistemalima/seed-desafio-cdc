package com.sistemalima.casadocodigodeveficiente.adapters.controller.book.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sistemalima.casadocodigodeveficiente.adapters.controller.author.entity.AuthorResponse;
import com.sistemalima.casadocodigodeveficiente.adapters.controller.category.entity.CategoryResponse;
import com.sistemalima.casadocodigodeveficiente.domain.Author;
import com.sistemalima.casadocodigodeveficiente.domain.Book;
import com.sistemalima.casadocodigodeveficiente.domain.Category;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookResponse {

    private Long id;

    private String title;

    private String summedUp;

    private String summary;

    private BigDecimal price;

    private Integer page;

    private String isbn;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicationDate;

    private CategoryResponse categoryResponse;

    private AuthorResponse authorResponse;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    @Deprecated
    public BookResponse() {
    }

    public BookResponse(Long id, String title, String summedUp, String summary, BigDecimal price, Integer page, String isbn, LocalDate publicationDate, Category category, Author author, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.title = title;
        this.summedUp = summedUp;
        this.summary = summary;
        this.price = price;
        this.page = page;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.categoryResponse = category.toResponse();
        this.authorResponse = author.toResponse();
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public BookResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.summedUp = book.getSummedUp();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.page = book.getPage();
        this.isbn = book.getIsbn();
        this.publicationDate = book.getPublicationDate();
        this.categoryResponse = book.getCategory().toResponse();
        this.authorResponse = book.getAuthor().toResponse();
        this.createAt = book.getCreateAt();
        this.updateAt = book.getUpdateAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummedUp() {
        return summedUp;
    }

    public void setSummedUp(String summedUp) {
        this.summedUp = summedUp;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public CategoryResponse getCategoryResponse() {
        return categoryResponse;
    }

    public void setCategoryResponse(CategoryResponse categoryResponse) {
        this.categoryResponse = categoryResponse;
    }

    public AuthorResponse getAuthorResponse() {
        return authorResponse;
    }

    public void setAuthorResponse(AuthorResponse authorResponse) {
        this.authorResponse = authorResponse;
    }

    public LocalDateTime getCreatAt() {
        return createAt;
    }

    public void setCreatAt(LocalDateTime creatAt) {
        this.createAt = creatAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
