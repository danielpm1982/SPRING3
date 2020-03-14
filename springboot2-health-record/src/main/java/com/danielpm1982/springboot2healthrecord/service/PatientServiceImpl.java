package com.danielpm1982.springboot2healthrecord.service;
import com.danielpm1982.springboot2healthrecord.domain.Consultation;
import com.danielpm1982.springboot2healthrecord.domain.Patient;
import com.danielpm1982.springboot2healthrecord.domain.Person;
import com.danielpm1982.springboot2healthrecord.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientServiceInterface{
    private PatientRepository patientRepository;
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Override
    public Patient getPatient(Long id) {
        return patientRepository.getPatient(id);
    }
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.getAllPatients();
    }
    @Override
    public Person addPatient(Long id, String name, String email) {
        return patientRepository.addPatient(id, name, email);
    }
    @Override
    public Person addPatient(Patient patient) {
        return patientRepository.addPatient(patient.getId(), patient.getName(), patient.getEmail());
    }
    @Override
    public List<Consultation> addPatientRecordConsultation(Long patientId, LocalDate localDate, LocalTime localTimeStart, LocalTime localTimeEnd, Long professionalId, String diagnosis, String intervention) {
        return patientRepository.addPatientRecordConsultation(patientId, localDate, localTimeStart, localTimeEnd, professionalId, diagnosis, intervention);
    }
    @Override
    public List<Consultation> addPatientRecordConsultation(Long patientId, List<Consultation> consultationList) {
        consultationList.forEach(x->patientRepository.addPatientRecordConsultation(patientId, x.getLocalDate(), x.getLocalTimeStart(), x.getLocalTimeEnd(), x.getProfessionalId(), x.getDiagnosis(), x.getIntervention()));
        return patientRepository.getPatient(patientId).getPatientRecord().getConsultationList();
    }
}
