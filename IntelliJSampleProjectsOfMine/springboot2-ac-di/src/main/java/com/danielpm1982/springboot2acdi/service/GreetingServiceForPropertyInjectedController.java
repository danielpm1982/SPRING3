package com.danielpm1982.springboot2acdi.service;
import org.springframework.stereotype.Component;

@Component
public class GreetingServiceForPropertyInjectedController implements GreetingService {
    @Override
    public String greet(String nameToBeGreeted) {
        return "Hello, "+nameToBeGreeted+" from the PropertyInjectedController !";
    }
}

/*
This is the service implementation created for being selected and injected at the
PropertyInjectedController, by using there a @Qualifier.
*/
