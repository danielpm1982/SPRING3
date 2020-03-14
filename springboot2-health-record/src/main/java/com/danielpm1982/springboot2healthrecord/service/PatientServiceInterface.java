package com.danielpm1982.springboot2healthrecord.service;
import com.danielpm1982.springboot2healthrecord.domain.Consultation;
import com.danielpm1982.springboot2healthrecord.domain.Patient;
import com.danielpm1982.springboot2healthrecord.domain.Person;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface PatientServiceInterface {
    Patient getPatient(Long id);
    List<Patient> getAllPatients();
    Person addPatient(Long id, String name, String email);
    Person addPatient(Patient patient);
    List<Consultation> addPatientRecordConsultation(Long patientId, LocalDate localDate, LocalTime localTimeStart, LocalTime localTimeEnd, Long professionalId, String diagnosis, String intervention);
    List<Consultation> addPatientRecordConsultation(Long patientId, List<Consultation> consultationList);
}
