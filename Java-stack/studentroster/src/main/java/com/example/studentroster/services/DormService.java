package com.example.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentroster.models.Dorm;
import com.example.studentroster.repositories.DormRepo;

@Service
public class DormService {

    @Autowired
    DormRepo dormRepo;
public Dorm createDorm(Dorm dorm) {
    return dormRepo.save(dorm);
}

public List<Dorm> getAllDorms() {
    return dormRepo.findAll();
}

public Dorm findDormById(Long id) {
    return dormRepo.findById(id).orElse(null);
}
}
