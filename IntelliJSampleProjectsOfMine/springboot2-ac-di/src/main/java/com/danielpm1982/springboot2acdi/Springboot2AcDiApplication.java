package com.danielpm1982.springboot2acdi;
import com.danielpm1982.springboot2acdi.controller.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.Arrays;

@SpringBootApplication
public class Springboot2AcDiApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Springboot2AcDiApplication.class, args);
		System.out.println("Application Context registered beans name list:");
		Arrays.asList(ctx.getBeanDefinitionNames()).forEach(System.out::println);
		System.out.println("***********************************************************************************");
		System.out.println("Getting instance of welcomeController bean from Application Context:");
		System.out.println(ctx.getBean("welcomeController"));
		System.out.println("Executing 'welcomeController' bean welcome() method:");
		System.out.println(((WelcomeController)ctx.getBean("welcomeController")).welcome("John Smith"));
		System.out.println("***********************************************************************************");
		System.out.println("Getting a PropertyInjectedController instance and calling its getGreeting method, which uses the injected GreetingService bean:");
		System.out.println(((PropertyInjectedController)ctx.getBean("propertyInjectedController")).getGreeting("John Smith"));
		System.out.println("Getting a SetterInjectedController instance and calling its getGreeting method, which uses the injected GreetingService bean:");
		System.out.println(((SetterInjectedController)ctx.getBean("setterInjectedController")).getGreeting("John Smith"));
		System.out.println("Getting a ConstructorInjectedController instance and calling its getGreeting method, which uses the injected GreetingService bean:");
		System.out.println(((ConstructorInjectedController)ctx.getBean("constructorInjectedController")).getGreeting("John Smith"));
		System.out.println("***********************************************************************************");
		System.out.println("Getting a MultiLangController instance and calling its getGreeting method, which uses the injected GreetingService bean:");
		System.out.println(((MultiLangController)ctx.getBean("multiLangController")).getGreeting("John Smith"));
	}
}


/*
*****PROJECT DESCRIPTION:*****
(GitHub project link: https://github.com/danielpm1982/springboot-ac-di)
*/

/*
This is a simple example of how to use Spring Application Context and Dependency Injection, along with
Inversion of Control (IoC), in a Spring Boot 2 application, following SOLID Principles and doing some basic
JUnit5 unitary tests.

Stereotype annotations used: @Service, @Component, @Profile, @Primary, @Controller, @Autowired, @Qualifier
and test annotations. For more info read the project comments at each class, mainly at the Main class.

For more info about this project features read the comments at this class and at other classes of this project.

When using this application, you willingly agree to comply with the Copyright© License at the following GitHub
link: https://github.com/danielpm1982/springboot-ac-di/blob/master/README.md .

This application code is solely for individual learning purposes and is NOT INTENDED FOR ANY KIND OF COMMERCIAL
USE, nor has warranty of any type (for more info, read the Copyright© License above).

© 2020 Daniel Pinheiro Maia All Rights Reserved
Daniel Pinheiro Maia
danielpm1982.com
danielpm1982@gmail.com
linkedin.com/in/danielpm1982
Brazil
.
*/

/*
*****SEQUENCE OF FEATURES ADDED:*****
*/

/*
For now, this app receives the Application Context, gets and shows all beans names list registered at it
and then gets specifically the 'welcomeController' bean to call its method welcome(), passes a person name,
as argument, and finally gets the return from that controller method.
This example shows that all beans are instantiated automatically, using inversion of control, and then
the programmer can get one of its instances by requesting to the Application Context, using the name
of the bean, which by default is the name of the Annotated class begining with lowercase. This instance
from the Application Context can then be injected at the requesting class, preferably through a Constructor.
The testing of this new feature can be done by running this main class. No test classes produced.
*/

/*
Then, it was added 3 Controller classes for demonstrating the 3 types of dependency injections, in this
case a GreetingService dependency that returns a greeting for a person name argument passed to it. The
At the JUnit5 testing classes, the GreetingService dependency, that could be a Spring bean, is then
instantiated and manually injected at the Controllers, according to each respective injection strategy.
See the Controller classes, the Service classes and the test classes for more. The testing of these new
features can be done by running the test classes.
*/

/*
Instead of instantiating and injecting the beans manually at the test classes, as if simulating the real
Spring Dependency Injection, now we actually use Spring to do all that, and simply get each Controller
bean from the Application Context and call its getGreeting() method that uses the GreetingService bean
already instantiated and injected, according to Annotations, at each Controller. The stereotype annotations
used are @Service and @Component at the service package and the @Controller and @Autowired
at the controller package. In the case of the ConstructorInjectedController no @Autowired annotation is
necessary if only one constructor is present. The testing of this new feature can be done by running this
main class. No test classes produced.
*/

/*
In this next feature, we've refactored the service implementations to keep 3 different implementations of
Service, one for each type of Controller (Constructor, Property and Setter). For letting the Spring Container
to know which dependency implementation to use at the injection of the service instances at each Controller
object, we've used another stereotype annotation: @Qualifier. So that each Controller would have a different
@Service implementation injected according to the bean name passed to this @Qualifier annotation. The testing
of this new feature can be done by running this main class. No test classes produced.
*/

/*
Next, we demonstrate the use of the @Primary annotation by setting it at one of the service impl classes, namely
the GreetingServiceConstructor class. At the ConstructorInjectedController, where that implemented and instantiated
bean is supposed to be injected, instead of a constructor injection using @Qualifier we write another one with no
@Qualifier, so that the @Primary notation of the injecting bean can be tested. Of course, in any other class
where the injection of any of the GreetingService implementations is requested, and no @Qualifier has been used, it'll
be preferably injected the @Primary impl of this service interface automatically. The testing of this new
feature can be done by running this main class. No test classes produced.
*/

/*
We've refactored the code again to create 2 new types of service implementations, added with a @Profile annotation
and with the same ambiguous bean name for both. We've also created a new controller for testing this multilanguage
support use case. One of the services is selected by the english profile (or by default), the other by the spanish
profile. The profile values are set at the application.properties. The selection of the unique service bean changes
according to that profile value. If no value is set for the profile at the application.properties (or the code there
is commented) the bean with the "default" profile will be selected (the english one). For more comments see the new
created classes. The testing of this new feature can be done by running this main class. No test classes produced.
*/

/*
We've refactored the name of 3 of the implemented services, just to keep them more semantic.
And final comments and explaining corrections have been done at all the project.

THIS PROJECT IS NOW CLOSED !
*/
