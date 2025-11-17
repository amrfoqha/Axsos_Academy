package com.example.studentroster.models;





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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="dorms")
public class Dorm {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank
@Size(min = 2, max = 20, message = "Dorm name must be between 2 and 20 characters")
private String name;
@Column(updatable = false)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date createdAt;
@Column(updatable = true)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date updatedAt;

@OneToMany(mappedBy = "dorm", fetch = FetchType.LAZY)
private List<Student> students;

public List<Student> getStudents() {
    return students;
}

public void setStudents(List<Student> students) {
    this.students = students;
}

public Dorm() {
}

public Dorm(String name) {
    this.name = name;
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
@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }





}
