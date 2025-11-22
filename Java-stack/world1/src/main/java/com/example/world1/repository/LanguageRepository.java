package com.example.world1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.world1.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
    @Query("Select c.name,l.language,l.percentage from Language l join l.countries c where   l.percentage>89")
    List<Object[]> Query4();
}