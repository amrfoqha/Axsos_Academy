package com.example.productsandcategories.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.productsandcategories.models.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
    
    @Override
    List<Category> findAll();
    @Override
    Category findById(Long id);

}
