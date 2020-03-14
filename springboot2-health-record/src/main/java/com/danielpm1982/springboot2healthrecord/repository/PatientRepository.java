package com.danielpm1982.springboot2healthrecord.repository;
import com.danielpm1982.springboot2healthrecord.domain.Consultation;
import com.danielpm1982.springboot2healthrecord.domain.Patient;
import com.danielpm1982.springboot2healthrecord.domain.PatientRecord;
import com.danielpm1982.springboot2healthrecord.domain.Person;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PatientRepository extends PersonRepository{
    public Patient getPatient(Long id) {
        Person person = super.getPerson(id);
        return person instanceof Patient ? (Patient)person : null;
    }
    public List<Patient> getAllPatients() {
        List<Person> personList = super.getPersonList();
        return personList.stream().filter(x->x instanceof Patient).map(x->(Patient)x).collect(Collectors.toList());
    }
    public Person addPatient(Long id, String name, String email) {
        Patient patient = new Patient(id, name, email, new PatientRecord(new ArrayList<>()));
        return super.addPerson(patient);
    }
    public List<Consultation> addPatientRecordConsultation(Long patientId, LocalDate localDate, LocalTime localTimeStart, LocalTime localTimeEnd, Long professionalId, String diagnosis, String intervention) {
        Consultation consultation = new Consultation(localDate, localTimeStart, localTimeEnd, professionalId, diagnosis, intervention);
        ((Patient)super.getPerson(patientId)).getPatientRecord().getConsultationList().add(consultation);
        return ((Patient)super.getPerson(patientId)).getPatientRecord().getConsultationList();
    }
}
