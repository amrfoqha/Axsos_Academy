package com.example.loginandregistration.models;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "name is required ")
@Size(min = 2, max = 20, message = "User name must be between 2 and 20 characters")
private String name;

@NotBlank(message = "password is required ")
@Size(min = 8, max = 200, message = "User password must be at least 8 characters")
private String password;

@Transient
@NotBlank(message = "Confirm password is required ")
@Size(min = 8, max = 200, message = "Confirm password must be at least 8 characters")
private String confirm;

@NotBlank(message = "email is required ")
@Email(message = "Please enter a valid email")
private String email;

@Column(updatable = false)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date createdAt;
@Column(updatable = true)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date updatedAt;


@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    public User(String name, String password, String confirm, String email) {
        this.name = name;
        this.password = password;
        this.confirm = confirm;
        this.email = email;
    }

    public User() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirm() {
        return confirm;
    }
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    





}
