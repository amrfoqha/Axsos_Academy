package org.example.booksapi.services;

import org.example.booksapi.models.Book;
import org.example.booksapi.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook( String title, String desc, String lang, Integer numOfPages){
        Book book=new Book( title,  desc,  lang,  numOfPages);
        return bookRepository.save(book);
    }
    public Book getById( Long Id){
        Optional<Book> book=bookRepository.findById(Id);
        if (book.isPresent()) {
            return book.get();
        }
        return null;
    }


    public Book updateBook(long Id, String title, String desc, String lang, Integer numOfPages){
        Book book=getById(Id);
        if (book!=null){
            book.setTitle(title);
            book.setDescription(desc);
            book.setLanguage(lang);
            book.setPages(numOfPages);
            return bookRepository.save(book);
        }
        return null;
    }
     public void deleteBook(Long Id) {
        bookRepository.deleteById(Id);
     }
     public List<Book> allBooks(){
        List<Book> books= (List<Book>) bookRepository.findAll();
        return books;
     }


     }
