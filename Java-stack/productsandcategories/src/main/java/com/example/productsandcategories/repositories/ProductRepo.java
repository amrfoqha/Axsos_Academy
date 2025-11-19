package com.example.productsandcategories.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.productsandcategories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

       @Override
    List<Product> findAll();
}
