package com.danielpm1982.springboot2acdi.controller;
import com.danielpm1982.springboot2acdi.service.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {
    private GreetingService greetingService;
//    public ConstructorInjectedController(@Qualifier("greetingServiceForConstructorInjectedController") GreetingService greetingService){
//        this.greetingService = greetingService;
//    }
    public ConstructorInjectedController(GreetingService greetingService){ //Constructor injection of the GreetingService impl set as @Primary, with no need of @Qualifier
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
*/
