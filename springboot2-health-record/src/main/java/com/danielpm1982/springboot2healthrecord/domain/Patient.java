package com.danielpm1982.springboot2healthrecord.domain;

public class Patient extends Person {
    protected PatientRecord patientRecord;
    public Patient() {
    }
    public Patient(Long id, String name, String email, PatientRecord patientRecord) {
        super(id, name, email);
        this.patientRecord = patientRecord;
    }
    public PatientRecord getPatientRecord() {
        return patientRecord;
    }
    public void setPatientRecord(PatientRecord patientRecord) {
        this.patientRecord = patientRecord;
    }
    @Override
    public String toString() {
        return "Patient{" +
                "patientRecord=" + patientRecord +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return patientRecord != null ? patientRecord.equals(patient.patientRecord) : patient.patientRecord == null;
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (patientRecord != null ? patientRecord.hashCode() : 0);
        return result;
    }
}
