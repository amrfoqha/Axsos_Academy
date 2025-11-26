package com.exam.java_exam.model;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name must not be blank")
    @Column(nullable = false)
    @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters long")
    private String name;
    @NotBlank(message = "Email must not be blank")
    @Column(nullable = false)
    @Size(min = 3, max = 30, message = "Email must be between 3 and 30 characters long")
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message = "Password must not be blank")
    @Column(nullable = false)
    @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters long")
    private String password;
    @Transient
    @NotBlank(message = "Confirm Password must not be blank")
    @Column(nullable = false)
    @Size(min = 8, max = 30, message = "Confirm Password must be between 8 and 30 characters long")
    private String confirmPassword;
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @Column(updatable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    @OneToMany(mappedBy = "pubUser", fetch = FetchType.LAZY)
    private List<Task> publishedTasks;


    public User() {
    }

    public User(Long id, String name, String email, String password, String confirmPassword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    public List<Task> getPublishedTasks() {
        return publishedTasks;
    }

    public void setPublishedTasks(List<Task> publishedTasks) {
        this.publishedTasks = publishedTasks;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    


}
