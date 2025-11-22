package com.example.world1.service;

import com.example.world1.model.City;
import com.example.world1.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@Service
public class CitiesService {
    private final CityRepository cityRepository;

    @Autowired
    public CitiesService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public Optional<City> findById(Integer id) {
        return cityRepository.findById(id);
    }

    public City save(City city) {
        return cityRepository.save(city);
    }

    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }

    public Page<City> findAllPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return cityRepository.findAll(pageable);
    }

    public List<Object[]> Query3() {
        return cityRepository.Query3();
    }
    public List<Object[]> Query7() {
        return cityRepository.Query7();
    }
    
}