package com.danielpm1982.springboot2healthrecord;
import com.danielpm1982.springboot2healthrecord.controller.PatientController;
import com.danielpm1982.springboot2healthrecord.controller.ProfessionalController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Springboot2HealthRecordApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Springboot2HealthRecordApplication.class, args);
        ProfessionalController professionalController = (ProfessionalController) ctx.getBean("professionalController");
        professionalController.addProfessionalBootstrapDataLoad();
        professionalController.showAllProfessionals();
        PatientController patientController = (PatientController) ctx.getBean("patientController");
        patientController.addPatientBootstrapDataLoad();
        patientController.addConsultationBootstrapDataLoad();
        patientController.showPatient(194878L);
        patientController.showAllPatients();
    }
}
