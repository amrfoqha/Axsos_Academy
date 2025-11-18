package com.example.dojosandninjas.models;

import java.util.ArrayList;
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
// import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dojos")
public class Dojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is required")
    @Size(min = 4,max = 25, message = "name must be between 4 and 25 characters")
    private String name;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @OneToMany(mappedBy = "dojo",fetch=FetchType.LAZY)
    private List<Ninja> ninjas;

    public Dojo() {
    }


    public Dojo(String name) {
        this.name = name;
        this.ninjas = new ArrayList<Ninja>();
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






    public String getName() {
        return name;
    }






    public void setName(String name) {
        this.name = name;
    }






    public List<Ninja> getNinjas() {
        return ninjas;
    }






    public void setNinjas(Ninja ninjas) {
        this.ninjas.add(ninjas);
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
