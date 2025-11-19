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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="categories")
public class Category {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "name is required ")
@Size(min = 3, max = 20, message = "name must be between 3 and 20 characters")
private String name;
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "categories_products",joinColumns = @JoinColumn(name="category_id"),inverseJoinColumns = @JoinColumn(name="product_id"))
private List<Product> products;
@Column(updatable = false)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date createdAt;
@Column(updatable = true)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date updatedAt;

public Category() {
}

public Category(String name) {
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

public List<Product> getProducts() {
    return products;
}

public void setProducts(List<Product> products) {
    this.products = products;
}

public Date getUpdatedAt() {
    return updatedAt;
}





    


}