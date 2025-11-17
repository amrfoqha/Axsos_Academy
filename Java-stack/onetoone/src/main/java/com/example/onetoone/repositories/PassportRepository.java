package com.example.onetoone.repositories;
import com.example.onetoone.models.Passport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends CrudRepository<Passport, Long> {
    
}
