package com.example.dojosandninjas.services;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.models.Ninja;
import com.example.dojosandninjas.repositories.DojoRepository;
import com.example.dojosandninjas.repositories.NinjaRepository;

@Service
public class DojoAndNinjaService {
    private final DojoRepository dojoRepository;
    private final NinjaRepository ninjaRepository;

    public DojoAndNinjaService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
        this.dojoRepository = dojoRepository;
        this.ninjaRepository = ninjaRepository;
    }

    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }
    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }

    public Dojo getDojo(Long id){
        Optional<Dojo> optionDojo = dojoRepository.findById(id);
        if (optionDojo.isPresent()) {
            return optionDojo.get();
        }
        return null;
    }
    public Dojo getDojoById(Long id) {
        return getDojo(id);
    }




}
