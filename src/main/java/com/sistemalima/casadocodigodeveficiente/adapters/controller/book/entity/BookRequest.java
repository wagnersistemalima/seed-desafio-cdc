package com.sistemalima.casadocodigodeveficiente.adapters.controller.book.entity;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.validation.UniqueValue;
import com.sistemalima.casadocodigodeveficiente.domain.Book;
import com.sistemalima.casadocodigodeveficiente.repository.book.entity.BookEntity;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookRequest {

    @NotBlank
    @UniqueValue(domainClass = BookEntity.class, fieldName = "title")
    private String title;

    @NotBlank
    @Length(max = 500)
    private String summedUp;

    private String summary;

    @NotNull
    @Min(20)
    private BigDecimal price;

    @NotNull
    @Min(100)
    private Integer page;

    @NotBlank
    @UniqueValue(domainClass = BookEntity.class, fieldName = "isbn")
    private String isbn;

    @Future
    @NotNull
    private LocalDate publicationDate;

    @NotNull
    private Long idCategory;

    @NotNull
    private Long idAuthor;

    @Deprecated
    public BookRequest() {
    }

    public BookRequest(String title, String summedUp, String summary, BigDecimal price, Integer page, String isbn, LocalDate publicationDate, Long idCategory, Long idAuthor) {
        this.title = title;
        this.summedUp = summedUp;
        this.summary = summary;
        this.price = price;
        this.page = page;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.idCategory = idCategory;
        this.idAuthor = idAuthor;
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

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public Book toDomain() {

        return new Book(
                title = this.getTitle(),
                summedUp = this.getSummedUp(),
                summary = this.getSummary(),
                price = this.getPrice(),
                page = this.getPage(),
                isbn = this.getIsbn(),
                publicationDate = this.getPublicationDate(),
                null,
                null
        );
    }
}
