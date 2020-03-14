package com.danielpm1982.springboot2healthrecord.configAndBootstrapDataLoad;
import com.danielpm1982.springboot2healthrecord.domain.Consultation;
import java.util.List;
import java.util.Map;

public class ConsultationLoad {
    private Map<Long, List<Consultation>> consultationMap;
    public ConsultationLoad(Map<Long, List<Consultation>> consultationMap) {
        this.consultationMap = consultationMap;
    }
    public Map<Long, List<Consultation>> getConsultationMap() {
        return consultationMap;
    }
}
