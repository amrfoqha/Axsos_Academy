package com.example.burgertracker.repositories;
import com.example.burgertracker.models.Burger;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {
    

    List<Burger> findAll();

}
