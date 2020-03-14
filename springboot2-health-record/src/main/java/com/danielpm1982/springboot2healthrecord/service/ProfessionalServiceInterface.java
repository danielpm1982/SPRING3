package com.danielpm1982.springboot2healthrecord.service;
import com.danielpm1982.springboot2healthrecord.domain.Professional;
import java.util.List;

public interface ProfessionalServiceInterface {
    Professional getProfessional(Long id);
    List<Professional> getAllProfessionals();
    Professional addProfessional(Long id, String name, String email, int registryNo, String profession, String specialty);
    Professional addProfessional(Professional professional);
}
