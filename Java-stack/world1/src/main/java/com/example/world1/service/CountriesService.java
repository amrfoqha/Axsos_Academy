package com.example.world1.service;

import com.example.world1.model.Country;
import com.example.world1.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@Service
public class CountriesService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountriesService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Optional<Country> findById(Integer id) {
        return countryRepository.findById(id);
    }

    public Country save(Country country) {
        return countryRepository.save(country);
    }

    public void deleteById(Integer id) {
        countryRepository.deleteById(id);
    }

    public Page<Country> findAllPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return countryRepository.findAll(pageable);
    }

    public List<Object[]> Query1() {
        return countryRepository.Query1();
    }
    public List<Object[]> Query2() {
        return countryRepository.Query2();
    }
    public List<Object[]> Query5() {
        return countryRepository.Query5();
    }

    public List<Object[]> Query6() {
        return countryRepository.Query6();
    }
    public List<Object[]> Query8() {
        return countryRepository.Query8();
    }

}