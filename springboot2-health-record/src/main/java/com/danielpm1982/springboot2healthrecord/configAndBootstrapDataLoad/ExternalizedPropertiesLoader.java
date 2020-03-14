package com.danielpm1982.springboot2healthrecord.configAndBootstrapDataLoad;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
@PropertySources({
    @PropertySource("patient.properties"),
    @PropertySource("professional.properties"),
    @PropertySource("consultation.properties")
})
public class ExternalizedPropertiesLoader {
    @Value(value="${patient1}")
    private List<String> patient1Values;
    @Value(value="${patient2}")
    private List<String> patient2Values;
    @Value(value="${patient3}")
    private List<String> patient3Values;
    @Value(value="${professional1}")
    private List<String> professional1Values;
    @Value(value="${professional2}")
    private List<String> professional2Values;
    @Value(value="${professional3}")
    private List<String> professional3Values;
    @Value(value="${consultation1}")
    private List<String> consultation1Values;
    @Value(value="${consultation2}")
    private List<String> consultation2Values;
    @Value(value="${consultation3}")
    private List<String> consultation3Values;
    private List<List<String>> allPatientsValuesList;
    private List<List<String>> allProfessionalsValuesList;
    private List<List<String>> allConsultationsValuesList;
    @PostConstruct
    public void createAndSetPatientValuesList(){
        allPatientsValuesList = Arrays.asList(patient1Values, patient2Values, patient3Values);
    }
    @PostConstruct
    public void createAndSetProfessionalList(){
        allProfessionalsValuesList = Arrays.asList(professional1Values, professional2Values, professional3Values);
    }
    @PostConstruct
    public void createAndSetConsultationList(){
        allConsultationsValuesList = Arrays.asList(consultation1Values, consultation2Values, consultation3Values);
    }
    public List<List<String>> getAllPatientsValuesList() {
        return allPatientsValuesList;
    }
    public List<List<String>> getAllProfessionalsValuesList() {
        return allProfessionalsValuesList;
    }
    public List<List<String>> getAllConsultationsValuesList() {
        return allConsultationsValuesList;
    }
}
