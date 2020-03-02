package com.danielpm1982.springboot2acdi.service;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class GreetingServiceForConstructorInjectedController implements GreetingService {
    @Override
    public String greet(String nameToBeGreeted) {
        return "Hello, "+nameToBeGreeted+" from the ConstructorInjectedController !";
    }
}

/*
This is the service implementation created for being selected and injected at the
ConstructorInjectedController, either by using there a @Qualifier or by using this
service bean as the @Primary to be selected preferable between all other candidates
when no @Qualifier is used at the injecting point.
*/
