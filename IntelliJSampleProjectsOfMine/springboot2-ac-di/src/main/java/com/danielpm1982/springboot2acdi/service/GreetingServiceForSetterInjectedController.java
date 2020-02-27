package com.danielpm1982.springboot2acdi.service;
import org.springframework.stereotype.Component;

@Component
public class GreetingServiceForSetterInjectedController implements GreetingService {
    @Override
    public String greet(String nameToBeGreeted) {
        return "Hello, "+nameToBeGreeted+" from the SetterInjectedController !";
    }
}

/*
This is the service implementation created for being selected and injected at the
SetterInjectedController, by using there a @Qualifier.
*/
