package com.example.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.burgertracker.models.Burger;
import com.example.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
    private final BurgerRepository burgerRepository;

    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }

    public void createBurger(Burger burger) {
        burgerRepository.save(burger);
    }

    public List<Burger> allRecords() {
        return  burgerRepository.findAll();
    }

    public Burger get(Long id) {
        Optional<Burger> burger = burgerRepository.findById(id);
        if (burger.isPresent()) {
            return burger.get();
        }
        return null;
    }

    public Burger updateBurger(Burger burger, Long id) {
        Burger oldBurger = get(id);
        if (oldBurger != null) {
            oldBurger.setName(burger.getName());
            oldBurger.setRestaurant(burger.getRestaurant());
            oldBurger.setRating(burger.getRating());
            oldBurger.setNotes(burger.getNotes());
            burgerRepository.save(oldBurger);
        }
        return oldBurger;
    }
}
