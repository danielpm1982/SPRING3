package com.danielpm1982.bookcatalog.controller;
import com.danielpm1982.bookcatalog.domain.Author;
import com.danielpm1982.bookcatalog.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;
    public AuthorController(AuthorRepository authorRepository){
        this.authorRepository=authorRepository;
    }
    @RequestMapping("/authors")
    public String getAllAuthors(Model model){
        Iterable<Author> authorIterable = authorRepository.findAll();
        model.addAttribute("authors", authorIterable);
        return "bookcatalog/authors";
    }
}
