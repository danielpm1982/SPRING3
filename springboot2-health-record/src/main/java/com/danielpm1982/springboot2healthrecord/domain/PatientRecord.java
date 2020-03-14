package com.danielpm1982.springboot2healthrecord.domain;
import java.util.List;

public class PatientRecord {
    protected List<Consultation> consultationList;
    public PatientRecord() {
    }
    public PatientRecord(List<Consultation> consultationList) {
        this.consultationList = consultationList;
    }
    public List<Consultation> getConsultationList() {
        return consultationList;
    }
    public void setConsultationList(List<Consultation> consultationList) {
        this.consultationList = consultationList;
    }
    @Override
    public String toString() {
        return "PatientRecord{" +
                "consultationList=" + consultationList +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientRecord that = (PatientRecord) o;
        return consultationList != null ? consultationList.equals(that.consultationList) : that.consultationList == null;
    }
    @Override
    public int hashCode() {
        return consultationList != null ? consultationList.hashCode() : 0;
    }
}
