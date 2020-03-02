package com.danielpm1982.springboot2acdi.controller;
import com.danielpm1982.springboot2acdi.service.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class MultiLangController {
    private GreetingService greetingService;
    public MultiLangController(@Qualifier("greetingServiceMultiLang")GreetingService greetingService){ //setting a dubious @Qualifier for a bean with multiple profiles. From these beans, that match this qualifier name, the one to be injected will depend also on the profile value (set at the application.properties or set as the default).
        this.greetingService = greetingService;
    }
    public String getGreeting(String name){
        return greetingService.greet(name);
    }
}

/*
This controller receives the injected bean through its Constructor and associates it to the greetingService
local field so that it can have its methods called.

Then, through its getGreeting() method, and using the injected greeting bean, this controller receives a name, passes
it to the injected bean when calling its greet() method, receives the bean dynamically generated response and returns
that to the calling object, in this case the controller instance itself at the main method.

The difference from the other controllers is that here the @Qualifier bean name is not sufficient anymore to
specify to the Spring Container whose bean should be selected for injection, as now there are more than one
bean that matches the qualifier name. The bean to be selected thus will be ultimately defined by the profile,
whose value is set at the application.properties, or by the bean with the default profile, if no profile is
set customly.
*/
