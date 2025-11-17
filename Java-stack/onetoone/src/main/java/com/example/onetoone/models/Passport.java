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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "passports")
public class Passport {
@Id
@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "PID is required")
@Size(min=3,max=20,message="PID name must be between 5 and 20 characters")
private String pID;
@NotBlank(message="location is required")
@Size(min=5,max=50,message="location must be between 5 and 20 characters")
private String location;

@NotNull(message = "nationality is required")
@Size(min=10,max=50, message="nationality must be at least 10")
private String nationality;

@OneToOne(mappedBy = "passport", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private Person person;

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
    public Passport() {
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public Passport(String pID, String location, String nationality) {
        this.pID = pID;
        this.location = location;
        this.nationality = nationality;
    }
    public String getpID() {
        return pID;
    }
    public void setpID(String pID) {
        this.pID = pID;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
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
     
    
    

}

