package com.example.studentroster.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="students")
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank
@Size(min = 3, max = 20, message = "Student name must be between 3 and 20 characters")
private String name;
@Column(updatable = false)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date createdAt;
@Column(updatable = true)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date updatedAt;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="dorm_id")
private Dorm dorm;

public Student() {
}

public Student(String name) {
    this.name = name;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Dorm getDorm() {
    return dorm;
}

public void setDorm(Dorm dorm) {
    this.dorm = dorm;
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
@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }



}
