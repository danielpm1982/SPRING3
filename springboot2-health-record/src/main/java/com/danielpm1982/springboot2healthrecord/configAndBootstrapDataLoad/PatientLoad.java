package com.danielpm1982.springboot2healthrecord.configAndBootstrapDataLoad;
import com.danielpm1982.springboot2healthrecord.domain.Patient;
import java.util.List;

public class PatientLoad {
    private List<Patient> patientList;
    public PatientLoad(List<Patient> patientList) {
        this.patientList = patientList;
    }
    public List<Patient> getPatientList() {
        return patientList;
    }
}
