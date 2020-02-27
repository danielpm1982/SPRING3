package com.danielpm1982.springboot2acdi.service;
import org.springframework.stereotype.Service;

@Service
public interface GreetingService {
    String greet(String nameToBeGreeted);
}

/*
This service interface defines the one and only method greet() that all its
implementations should implement.
The implementations of this service are the beans to be selected and later
injected at the controllers... either via property (field), setter or preferably
via constructor.
At the controllers, the reference to these beans should be oriented to this
interface and not to its implementations, in order to obey the SOLID principles.
The instantiation of the implemented services will be either done manually (at the
testing classes) or automatically, using the @Annotations and the inversion
of control and dependency injection of Spring.
*/
