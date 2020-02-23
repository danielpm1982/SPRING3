package com.danielpm1982.bookcatalog.controller;
import com.danielpm1982.bookcatalog.domain.Publisher;
import com.danielpm1982.bookcatalog.repository.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublisherController {
    private final PublisherRepository publisherRepository;
    public PublisherController(PublisherRepository publisherRepository){
        this.publisherRepository=publisherRepository;
    }
    @RequestMapping("/publishers")
    public String getAllPublishers(Model model){
        Iterable<Publisher> publisherIterable = publisherRepository.findAll();
        model.addAttribute("publishers", publisherIterable);
        return "bookcatalog/publishers";
    }
}
