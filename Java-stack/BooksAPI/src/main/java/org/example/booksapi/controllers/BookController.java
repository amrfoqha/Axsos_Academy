package org.example.booksapi.controllers;

import org.example.booksapi.models.Book;
import org.example.booksapi.repositories.BookRepository;
import org.example.booksapi.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }
    @RequestMapping("/books/{id}")
    public String displayBook(@PathVariable("id")Long id, Model model){
        model.addAttribute("book",bookService.getById(id));
        return "index.jsp";
    }
    @RequestMapping("/books")
    public String index(Model model) {

        model.addAttribute("books", bookService.allBooks());
        return "records.jsp";
    }

}
