package com.example.studentroster.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.studentroster.models.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

}
