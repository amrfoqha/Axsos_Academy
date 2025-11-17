package com.example.onetoone.services;


import java.util.List;
import org.springframework.stereotype.Service;
import com.example.onetoone.models.Person;
import com.example.onetoone.repositories.PersonRepository;

@Service
public class PersonService {

    private PersonRepository personRepository;
    
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
   
    public Person add(Person person) {
        return personRepository.save(person);
    }
    public Person getById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
    
}
