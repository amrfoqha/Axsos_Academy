package com.example.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.example.savetravels.models.Travel;
import com.example.savetravels.repositories.TravelRepository;

@Service
public class TravelService {
    private final TravelRepository travelRepository;

    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    public void createTravel(Travel travel) {
        travelRepository.save(travel);
    }

    public List<Travel> allRecords() {
        return  travelRepository.findAll();
    }

    public Travel get(Long id) {
        Optional<Travel> travel = travelRepository.findById(id);
        if (travel.isPresent()) {
            return travel.get();
        }
        return null;
    }

    public Travel updateTravel(Travel travel, Long id) {
        Travel oldTravel = get(id);
        if (oldTravel != null) {
            oldTravel.setExpense(travel.getExpense());
            oldTravel.setVendor(travel.getVendor());
            oldTravel.setAmount(travel.getAmount());
            oldTravel.setDescription(travel.getDescription());
            travelRepository.save(oldTravel);
        }
        return oldTravel;
    }

    public void deleteTravel(Long id) {
        travelRepository.deleteById(id);
    }
    
}
