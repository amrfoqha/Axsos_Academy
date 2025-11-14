package com.example.savetravels.repositories;
import com.example.savetravels.models.Travel;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long> {
    

    List<Travel> findAll();

}
