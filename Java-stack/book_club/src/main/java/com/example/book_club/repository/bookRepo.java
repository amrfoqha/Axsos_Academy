package com.example.book_club.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.book_club.model.Book;

@Repository
public interface bookRepo extends CrudRepository<Book, Long> {

    List<Book> findAll();
}
