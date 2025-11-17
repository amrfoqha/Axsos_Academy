package com.example.studentroster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentroster.models.Student;
import com.example.studentroster.repositories.StudentRepo;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public Student save(Student student) {
        return studentRepo.save(student);
    }
    public Student findStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }
}
