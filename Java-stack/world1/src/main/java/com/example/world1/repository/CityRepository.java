package com.example.world1.repository;

import com.example.world1.model.City;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    @Query("select c.name,c.population from City c join c.countries co where co.name='Mexico' and c.population>500000 order by c.population desc")
    List<Object[]> Query3();
    @Query("select co.name,c.name,c.district,c.population from City c join c.countries co where co.name='Argentina' and c.district='Buenos Aires' and c.population>500000")
    List<Object[]> Query7();
}