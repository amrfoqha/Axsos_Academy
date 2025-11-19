package com.example.productsandcategories.models;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "name is required ")
@Size(min = 3, max = 20, message = "name must be between 3 and 20 characters")
private String name;
@NotBlank(message = "description is required ")
@Size(min = 3, max = 20, message = "description must be between 3 and 20 characters")
private String description;
@NotNull(message = "Price is required ")
private double price;
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "categories_products",joinColumns = @JoinColumn(name="product_id"),inverseJoinColumns = @JoinColumn(name="category_id"))
private List<Category> categories;



@Column(updatable = false)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date createdAt;
@Column(updatable = true)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date updatedAt;




public Product() {
    
}
public Product(String name,String description,double price) {
    this.name = name;
    this.description = description;
    this.price = price;
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
    protected void onUpdate() {
        this.updatedAt = new Date();
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
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    

    
    
    





}
