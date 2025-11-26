package com.exam.java_exam.model;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title must not be blank")
    @Column(nullable = false)
    @Size(min = 2, max = 30, message = "Title must be between 2 and 30 characters long")
    private String name;
    @NotBlank(message = "Description must not be blank")
    @Column(nullable = false)
    @Size(min = 2, max = 100, message = "Description must be between 2 and 30 characters long")
    private String description;
    @NotNull(message = "Due Date must not be blank")
    @Column(nullable = false)
    @FutureOrPresent(message = "Due Date must be in the future or present")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;
    @Column(nullable = false)
    @Size(min = 2, max = 30, message = "Status must be between 2 and 30 characters long")
    private String status = "inProgress";
    @Column(nullable = false)
    private boolean isImportant=false;
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date createdAt;
    @Column(updatable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User pubUser;

   

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    public Task() {
    }

    public Task(Long id, String name, String description, Date dueDate) {

        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
 
   
    public boolean getIsImportant() {
        return isImportant;
    }
    public void setIsImportant(boolean isImportant) {
        this.isImportant = isImportant;
    }
    public User getPubUser() {
        return pubUser;
    }
    public void setPubUser(User pubUser) {
        this.pubUser = pubUser;
    }
    


}
