package com.example.book_club.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book_club.model.Book;
import com.example.book_club.repository.bookRepo;

@Service
public class TaskService {

@Autowired
private bookRepo bookRepo;

public Book createBook(Book book) {
    return bookRepo.save(book);
}
public List<Book> getAllBooks() {
    return bookRepo.findAll();
}

}
