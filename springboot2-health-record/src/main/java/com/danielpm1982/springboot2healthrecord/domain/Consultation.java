package com.danielpm1982.springboot2healthrecord.domain;
import java.time.LocalDate;
import java.time.LocalTime;

public class Consultation {
    protected LocalDate localDate;
    protected LocalTime localTimeStart;
    protected LocalTime localTimeEnd;
    protected Long professionalId;
    protected String diagnosis;
    protected String intervention;
    public Consultation() {
    }
    public Consultation(LocalDate localDate, LocalTime localTimeStart, LocalTime localTimeEnd, Long professionalId, String diagnosis, String intervention) {
        this.localDate = localDate;
        this.localTimeStart = localTimeStart;
        this.localTimeEnd = localTimeEnd;
        this.professionalId = professionalId;
        this.diagnosis = diagnosis;
        this.intervention = intervention;
    }
    public LocalDate getLocalDate() {
        return localDate;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    public LocalTime getLocalTimeStart() {
        return localTimeStart;
    }
    public void setLocalTimeStart(LocalTime localTimeStart) {
        this.localTimeStart = localTimeStart;
    }
    public LocalTime getLocalTimeEnd() {
        return localTimeEnd;
    }
    public void setLocalTimeEnd(LocalTime localTimeEnd) {
        this.localTimeEnd = localTimeEnd;
    }
    public Long getProfessionalId() {
        return professionalId;
    }
    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public String getIntervention() {
        return intervention;
    }
    public void setIntervention(String intervention) {
        this.intervention = intervention;
    }
    @Override
    public String toString() {
        return "Consultation{" +
                "localDate=" + localDate +
                ", localTimeStart=" + localTimeStart +
                ", localTimeEnd=" + localTimeEnd +
                ", professionalId=" + professionalId +
                ", diagnosis='" + diagnosis + '\'' +
                ", intervention='" + intervention + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultation that = (Consultation) o;
        return localDate != null ? localDate.equals(that.localDate) : that.localDate == null;
    }
    @Override
    public int hashCode() {
        return localDate != null ? localDate.hashCode() : 0;
    }
}
