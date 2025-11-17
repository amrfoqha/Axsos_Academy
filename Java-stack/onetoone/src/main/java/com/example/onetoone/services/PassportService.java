package com.example.onetoone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onetoone.models.Passport;
import com.example.onetoone.repositories.PassportRepository;

@Service
public class PassportService {
    @Autowired
    private PassportRepository passportRepository;
    public Passport add(Passport passport) {
        return passportRepository.save(passport);
    }
}
