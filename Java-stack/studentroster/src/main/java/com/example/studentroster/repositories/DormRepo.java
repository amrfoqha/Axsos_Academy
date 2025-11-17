package com.example.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.studentroster.models.Dorm;

@Repository
public interface DormRepo extends CrudRepository<Dorm, Long> {

    @Override
    List<Dorm> findAll();

    
}
