package com.danielpm1982.springboot2healthrecord.service;
import com.danielpm1982.springboot2healthrecord.domain.Professional;
import com.danielpm1982.springboot2healthrecord.repository.ProfessionalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfessionalServiceImpl implements ProfessionalServiceInterface{
    private ProfessionalRepository professionalRepository;
    public ProfessionalServiceImpl(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }
    @Override
    public Professional getProfessional(Long id) {
        return professionalRepository.getProfessional(id);
    }
    @Override
    public List<Professional> getAllProfessionals() {
        return professionalRepository.getAllProfessionals();
    }
    @Override
    public Professional addProfessional(Long id, String name, String email, int registryNo, String profession, String specialty) {
        return professionalRepository.addProfessional(id, name, email, registryNo, profession, specialty);
    }
    @Override
    public Professional addProfessional(Professional professional) {
        return professionalRepository.addProfessional(professional.getId(), professional.getName(), professional.getEmail(), professional.getRegistryNo(), professional.getProfession(), professional.getSpecialty());
    }
}
