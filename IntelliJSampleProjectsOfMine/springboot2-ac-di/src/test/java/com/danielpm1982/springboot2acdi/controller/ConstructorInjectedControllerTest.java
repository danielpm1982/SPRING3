package com.danielpm1982.springboot2acdi.controller;
import com.danielpm1982.springboot2acdi.service.GreetingServiceForConstructorInjectedController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {
    ConstructorInjectedController constructorInjectedController;
    @BeforeEach
    void setUp() {
        constructorInjectedController = new ConstructorInjectedController(new GreetingServiceForConstructorInjectedController()); //manually simulating the instantiation and constructor injection of the GreetingService bean at the Controller, for later being used at the Controller methods. When injected, the bean instance would be accessable through a Controller property to all Controller methods, as in all 3 types of bean injection. This would be a constructor-injection strategy.
    }
    @Test
    void getGreeting() {
        System.out.println(constructorInjectedController.getGreeting("John Smith")); //testing the use of the constructor injected bean from inside a Controller method.
    }
}
