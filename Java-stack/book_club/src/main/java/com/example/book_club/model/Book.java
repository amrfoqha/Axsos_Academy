package com.example.book_club.model;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title must not be blank")
    @Column(nullable = false)
    @Size(min = 2, max = 30, message = "Title must be between 2 and 30 characters long")
    private String title;
    @NotBlank(message = "Author must not be blank")
    @Column(nullable = false)
    @Size(min = 2, max = 30, message = "Author must be between 2 and 30 characters long")
    private String author;
    @NotBlank(message = "Publisher must not be blank")
    @Column(nullable = false)
    @Size(min = 8, max = 30, message = "Publisher must be between 8 and 30 characters long")
    private String publisher;
    @NotBlank(message = "Description must not be blank")
    @Column(nullable = false)
    @Size(min = 8, max = 30, message = "Description must be between 8 and 30 characters long")
    private String description;
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @Column(updatable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User pubUser;


    public User getPubUser() {
        return pubUser;
    }

    public void setPubUser(User pubUser) {
        this.pubUser = pubUser;
    }



    public Book() {
    }

    public Book(Long id, String title, String author, String publisher, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }


}
