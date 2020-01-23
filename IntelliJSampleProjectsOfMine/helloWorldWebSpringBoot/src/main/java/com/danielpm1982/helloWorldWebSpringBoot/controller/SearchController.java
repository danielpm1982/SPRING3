package com.danielpm1982.helloWorldWebSpringBoot.controller;
import com.danielpm1982.helloWorldWebSpringBoot.entity.Client;
import com.danielpm1982.helloWorldWebSpringBoot.exception.MyException;
import com.danielpm1982.helloWorldWebSpringBoot.repository.HelloWorldRepositorySpringDataInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.List;

@Controller
public class SearchController{
    @Autowired
    HelloWorldRepositorySpringDataInterface helloWorldRepositorySpringDataInterface;
    @RequestMapping("/searchClient")
    public String showResultPage(@Valid @ModelAttribute("searchClientModelAttribute") Client client, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("searchClientModelAttribute", client);
            model.addAttribute("addClientModelAttribute", new Client());
            return "form";
        }
        Client foundClient = null;
        try {
            foundClient = helloWorldRepositorySpringDataInterface.findByEmail(client.getEmail());
        } catch (MyException e) {
            System.err.println(e.getMessage());
            model.addAttribute("searchClientError", e.getMessage());
            model.addAttribute("searchClientModelAttribute", client);
            model.addAttribute("addClientModelAttribute", new Client());
            return "form";
        }
        List<Client> allClients = helloWorldRepositorySpringDataInterface.findAll();
        model.addAttribute("foundClient", foundClient);
        model.addAttribute("allClients", allClients);
        return "result";
    }
}
