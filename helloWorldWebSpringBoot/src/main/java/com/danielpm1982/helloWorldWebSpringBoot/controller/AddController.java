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
public class AddController{
    @Autowired
    HelloWorldRepositorySpringDataInterface helloWorldRepositorySpringDataInterface;
    @RequestMapping("/addClient")
    public String showResultPage(@Valid @ModelAttribute("addClientModelAttribute") Client client, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("addClientModelAttribute", client);
            model.addAttribute("searchClientModelAttribute", new Client());
            return "form";
        }
        Client addedClient = null;
        try {
            addedClient = helloWorldRepositorySpringDataInterface.add(client);
        } catch (MyException e) {
            System.err.println(e.getMessage());
            model.addAttribute("addClientError", e.getMessage());
            model.addAttribute("addClientModelAttribute", client);
            model.addAttribute("searchClientModelAttribute", new Client());
            return "form";
        }
        List<Client> allClients = helloWorldRepositorySpringDataInterface.findAll();
        model.addAttribute("addedClient", addedClient);
        model.addAttribute("allClients", allClients);
        return "result";
    }
}
