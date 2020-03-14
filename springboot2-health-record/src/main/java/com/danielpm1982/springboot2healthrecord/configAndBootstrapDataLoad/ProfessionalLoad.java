package com.danielpm1982.springboot2healthrecord.configAndBootstrapDataLoad;
import com.danielpm1982.springboot2healthrecord.domain.Professional;
import java.util.List;

public class ProfessionalLoad {
    private List<Professional> professionalList;
    public ProfessionalLoad(List<Professional> professionalList) {
        this.professionalList = professionalList;
    }
    public List<Professional> getProfessionalList() {
        return professionalList;
    }
}
