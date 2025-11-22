package com.example.world1.service;

import com.example.world1.model.Language;
import com.example.world1.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@Service
public class LanguagesService {
    private final LanguageRepository languageRepository;

    @Autowired
    public LanguagesService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    public Optional<Language> findById(Integer id) {
        return languageRepository.findById(id);
    }

    public Language save(Language language) {
        return languageRepository.save(language);
    }

    public void deleteById(Integer id) {
        languageRepository.deleteById(id);
    }

    public Page<Language> findAllPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return languageRepository.findAll(pageable);
    }
    public List<Object[]> Query4() {
        return languageRepository.Query4();
    }
}