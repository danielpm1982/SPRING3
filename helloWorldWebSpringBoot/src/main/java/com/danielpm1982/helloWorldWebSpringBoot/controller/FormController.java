package com.danielpm1982.helloWorldWebSpringBoot.controller;
import com.danielpm1982.helloWorldWebSpringBoot.entity.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
    @RequestMapping("/form")
    public String showFormPage(Model model) {
        model.addAttribute("addClientModelAttribute", new Client());
        model.addAttribute("searchClientModelAttribute", new Client());
        return "form";
    }
}
