package com.example.onetoone.models;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "persons")
public class Person {
@Id
@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
private Long id;

@NotNull(message = "First name is required")
@Size(min=3,max=20,message="First name must be between 3 and 20 characters")
private String firstName;
@NotNull(message="lastName is required")
@Size(min=3,max=20,message="lastName must be between 3 and 20 characters")
private String lastName;

@NotBlank(message ="Email is required")
@Email( message="Your email must be Valid")
private String email;


@OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "address_id")
private Passport passport;



@Column(updatable=false)
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date createdAt;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date updatedAt;


@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
    
    
    public Person() {
    }
    
    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
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
    
    
    
    
    public Passport getPassport() {
        return passport;
    }
    public void setPassport(Passport passport) {
        this.passport = passport;
    }
    
    
    
    
    
    
}

