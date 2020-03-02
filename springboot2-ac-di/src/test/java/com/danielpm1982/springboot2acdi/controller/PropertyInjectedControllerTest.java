package com.danielpm1982.springboot2acdi.controller;
import com.danielpm1982.springboot2acdi.service.GreetingServiceForPropertyInjectedController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {
    PropertyInjectedController propertyInjectedController;
    @BeforeEach
    void setUp() {
        propertyInjectedController = new PropertyInjectedController();
        propertyInjectedController.greetingService = new GreetingServiceForPropertyInjectedController(); //manually simulating the instantiation and property injection of the GreetingService bean at the Controller, for later being used at the Controller methods. When injected, the bean instance would be accessable through a Controller property to all Controller methods, as in all 3 types of bean injection. This set up method would be what Spring would automate behind the scenes when an @Autowire or @Inject annotation were used at the GreetingService property of the PropertyInjectedController. The Container, when creating the Controller, would instantiate and inject a GreetingService instance (a managed bean from the Application Context) at the GreetingService property of the Controller object for its methods to use. This would be a property or field-injection strategy.
    }
    @Test
    void getGreeting() {
        System.out.println(propertyInjectedController.getGreeting("John Smith")); //testing the use of the property injected bean from inside a Controller method.
    }
}
