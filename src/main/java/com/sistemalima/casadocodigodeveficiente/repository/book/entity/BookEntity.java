package com.sistemalima.casadocodigodeveficiente.repository.book.entity;

import com.sistemalima.casadocodigodeveficiente.domain.Book;
import com.sistemalima.casadocodigodeveficiente.repository.author.entity.AuthorEntity;
import com.sistemalima.casadocodigodeveficiente.repository.category.entity.CategoryEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador_book")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "summed_up")
    private String summedUp;

    @Column(name = "summary")
    private String summary;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "page")
    private Integer page;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    // chave estrangeira de categoria pode ou nao pode ser nulla / um ou mais livros tera que ser associado a uma categoria nullable = false
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    // chave estrangeira de author pode ou nao pode ser nulla / um ou mais livros tera que ser associado a uma author nullable = false
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity authorEntity;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Deprecated
    public BookEntity() {
    }

    public BookEntity(String title, String summedUp, String summary, BigDecimal price, Integer page, String isbn, LocalDate publicationDate, CategoryEntity categoryEntity, AuthorEntity authorEntity) {
        this.title = title;
        this.summedUp = summedUp;
        this.summary = summary;
        this.price = price;
        this.page = page;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.categoryEntity = categoryEntity;
        this.authorEntity = authorEntity;
    }

    public BookEntity(Long id, String title, String summedUp, String summary, BigDecimal price, Integer page, String isbn, LocalDate publicationDate, CategoryEntity categoryEntity, AuthorEntity authorEntity, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.title = title;
        this.summedUp = summedUp;
        this.summary = summary;
        this.price = price;
        this.page = page;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.categoryEntity = categoryEntity;
        this.authorEntity = authorEntity;
        this.createAt = createAt;
        this.updateAt = updateAt;
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

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public AuthorEntity getAuthorEntity() {
        return authorEntity;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setSummedUp(String summedUp) {
        this.summedUp = summedUp;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public void setAuthorEntity(AuthorEntity authorEntity) {
        this.authorEntity = authorEntity;
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

    public CategoryEntity getCategory() {
        return categoryEntity;
    }

    public void setCategory(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public AuthorEntity getAuthor() {
        return authorEntity;
    }

    public void setAuthor(AuthorEntity author) {
        this.authorEntity = author;
    }

    public LocalDateTime getCreatAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getIsbn(), that.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getIsbn());
    }

    @PrePersist
    public void prePersiste() {
        createAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateAt = LocalDateTime.now();
    }

    public Book toDomain() {
        return new Book(
                id = this.getId(),
                title = this.getTitle(),
                summedUp = this.getSummedUp(),
                summary = this.getSummary(),
                price = this.getPrice(),
                page  = this.getPage(),
                isbn = this.getIsbn(),
                publicationDate = this.getPublicationDate(),
                this.getCategory().toDomain(),
                this.getAuthor().toDomain(),
                createAt = this.getCreatAt(),
                updateAt = this.getUpdateAt()
        );
    }
}
