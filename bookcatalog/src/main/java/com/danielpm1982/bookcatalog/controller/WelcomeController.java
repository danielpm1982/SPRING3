package com.danielpm1982.bookcatalog.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Controller
public class WelcomeController {
    @RequestMapping("/")
    public String welcome(Model model){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        String zonedDateTimeString = zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL));
        model.addAttribute("dateTime", zonedDateTimeString);
        return "bookcatalog/welcome";
    }
}
