package com.example.productsandcategories.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.models.Product;
import com.example.productsandcategories.repositories.CategoryRepo;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ProductService productService;

    public Category createCategory(Category category) {   
    return categoryRepo.save(category);
    }
    
    public Category findCategoryById(Long id) {
        return categoryRepo.findById(id);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public List<Category> categoriesNotON(Product product) {
        List<Category> pArr = product.getCategories();
        List<Category> cArr = getAllCategories();
        List<Category> Aux = new ArrayList<Category>();
        for (Category category : cArr) {
            if (!pArr.contains(category)) {
                Aux.add(category);
            }
        }
        return Aux;
    }

    public void linkTo(Long productId, Long categoryId) {

    Category category = findCategoryById(categoryId);
    Product existingProduct = productService.findProductById(productId);

    category.getProducts().add(existingProduct);

    categoryRepo.save(category);
}

}
