package com.danielpm1982.bookcatalog.controller;
import com.danielpm1982.bookcatalog.domain.Book;
import com.danielpm1982.bookcatalog.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    private final BookRepository bookRepository;
    public BookController(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    @RequestMapping("/books")
    public String getAllBooks(Model model){
        Iterable<Book> bookIterable = bookRepository.findAll();
        model.addAttribute("books", bookIterable);
        return "bookcatalog/books";
    }
}
