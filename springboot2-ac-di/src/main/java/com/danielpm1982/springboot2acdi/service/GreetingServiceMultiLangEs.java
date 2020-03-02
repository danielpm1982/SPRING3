package com.danielpm1982.springboot2acdi.service;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("greetingServiceMultiLang")
@Profile("ES")
public class GreetingServiceMultiLangEs implements GreetingService{
    @Override
    public String greet(String nameToBeGreeted) {
        return "Hola, "+nameToBeGreeted+" - en Español !";
    }
}

/*
For the dubious greetingServiceMultiLang bean name above (equal for the both multilang beans), the profile
value set at the application.properties is the one who will ultimately decide which of the greetingServiceMultiLang
beans to select for injection at the multilang Controller. The @Qualifier at the controller only selects in part,
as it sets the greetingServiceMultiLang name for the bean, but that's still ambiguous. The profile value then resolves
that ambiguity by adding its value to the @Qualifier value in order to finally select the unique and correct bean to be
injected - either the EN or the ES version. By changing the profile value, at the application.properties, you change the
selection of the beans.
*/
