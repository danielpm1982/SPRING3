package com.danielpm1982.springboot2healthrecord.repository;
import com.danielpm1982.springboot2healthrecord.domain.Person;
import com.danielpm1982.springboot2healthrecord.domain.Professional;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProfessionalRepository extends PersonRepository{
    public Professional getProfessional(Long id) {
        Person person = super.getPerson(id);
        return (person instanceof Professional ? (Professional)person : null);
    }
    public List<Professional> getAllProfessionals(){
        return super.getPersonList().stream().filter(x->x instanceof Professional).map(x->(Professional)x).collect(Collectors.toList());
    }
    public Professional addProfessional(Long id, String name, String email, int registryNo, String profession, String specialty) {
        Professional professional = new Professional(id, name, email, registryNo, profession, specialty);
        return (Professional)super.addPerson(professional);
    }
}
