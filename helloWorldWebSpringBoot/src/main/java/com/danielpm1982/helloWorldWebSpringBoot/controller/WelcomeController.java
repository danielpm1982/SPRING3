package com.danielpm1982.helloWorldWebSpringBoot.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    @RequestMapping("/")
    public String showIndexPage() {
        return "index";
    }
}
