package com.example.world1.repository;

import com.example.world1.model.Country;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query("SELECT c.name,l.language,l.percentage FROM Country c join c.languages l where l.language='Slovene'")
    List<Object[]> Query1();

    // @Query("SELECT c.name, COUNT(ci) FROM Country c JOIN c.cities ci GROUP BY c.name ORDER BY COUNT(ci) DESC")
    @Query("select c.name,Count(ci) from Country c join c.cities ci group by c.name order by count(ci) desc")
    List<Object[]> Query2();

    @Query("select c.name , c.surfaceArea from Country c where c.surfaceArea < 501 and c.population > 100000")
    List<Object[]> Query5();

    @Query("select c.name,c.governmentForm,c.surfaceArea,c.lifeExpectancy from Country c where c.governmentForm='Constitutional Monarchy' and c.surfaceArea > 200 and c.lifeExpectancy > 75")
    List<Object[]> Query6();

    @Query("select c.region,count(*) from Country c group by c.region order by count(*) desc ")
    List<Object[]> Query8();
}