package com.danielpm1982.springboot2healthrecord.repository;
import com.danielpm1982.springboot2healthrecord.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PersonRepository{
    @Autowired
    protected Db db;
    protected List<Person> getPersonList(){
        return db.getPersonList();
    }
    protected Person getPerson(Long id) {
        return db.getPersonList().stream().filter(x->x.getId().compareTo(id)==0).findFirst().orElse(null);
    }
    protected Person addPerson(Person person){
        db.getPersonList().add(person);
        return db.getPersonList().stream().filter(x->x.getId()==person.getId()).findFirst().orElse(null);
    }
}
