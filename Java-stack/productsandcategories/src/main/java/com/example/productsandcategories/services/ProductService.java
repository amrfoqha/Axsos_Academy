package com.example.productsandcategories.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.models.Product;
import com.example.productsandcategories.repositories.CategoryRepo;
import com.example.productsandcategories.repositories.ProductRepo;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;

    public Product createProduct(Product product) {
        
    return productRepo.save(product);
    }
    
    public Product findProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
    
    public List<Product> productsNotON(Category category) {
        List<Product> pArr = category.getProducts();
        List<Product> cArr = getAllProducts();
        List<Product> Aux = new ArrayList<Product>();
        for (Product product : cArr) {
            if (!pArr.contains(product)) {
                Aux.add(product);
            }
        }
        return Aux;
    }

    public void linkTo(Long categoryId, Long productId) {

    Product product = findProductById(productId);
    Category existingCategory = categoryRepo.findById(categoryId);

    product.getCategories().add(existingCategory);

    productRepo.save(product);
}

    
}
