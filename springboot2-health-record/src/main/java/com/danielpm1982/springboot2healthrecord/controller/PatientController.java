package com.danielpm1982.springboot2healthrecord.controller;
import com.danielpm1982.springboot2healthrecord.configAndBootstrapDataLoad.ConsultationLoad;
import com.danielpm1982.springboot2healthrecord.configAndBootstrapDataLoad.PatientLoad;
import com.danielpm1982.springboot2healthrecord.service.PatientServiceInterface;
import org.springframework.stereotype.Controller;

@Controller
public class PatientController {
    private PatientServiceInterface patientServiceInterface;
    private PatientLoad patientLoad;
    private ConsultationLoad consultationLoad;
    public PatientController(PatientServiceInterface patientServiceInterface, PatientLoad patientLoad, ConsultationLoad consultationLoad) {
        this.patientServiceInterface = patientServiceInterface;
        this.patientLoad = patientLoad;
        this.consultationLoad = consultationLoad;
    }
    public void addPatientBootstrapDataLoad(){
        System.out.println("Adding patients:");
        patientLoad.getPatientList().forEach(x->patientServiceInterface.addPatient(x));
        System.out.println("Added Successfully !");
        System.out.println("Showing all patients:");
        patientServiceInterface.getAllPatients().forEach(System.out::println);
    }
    public void addConsultationBootstrapDataLoad(){
        System.out.println("Adding consultations:");
        consultationLoad.getConsultationMap().forEach((x,y)->patientServiceInterface.addPatientRecordConsultation(x,y));
        System.out.println("Added Successfully !");
    }
    public void showPatient(Long id){
        System.out.println("Showing Patient id = "+id+":");
        System.out.println(patientServiceInterface.getPatient(id));
    }
    public void showAllPatients(){
        System.out.println("Showing all patients:");
        patientServiceInterface.getAllPatients().forEach(System.out::println);
    }
}
