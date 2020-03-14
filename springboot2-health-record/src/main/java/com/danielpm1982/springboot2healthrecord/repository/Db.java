package com.danielpm1982.springboot2healthrecord.repository;
import com.danielpm1982.springboot2healthrecord.domain.Person;
import java.util.List;

public class Db {
    private List<Person> personList;
    public Db(List<Person> personList) {
        this.personList = personList;
    }
    public List<Person> getPersonList() {
        return personList;
    }
}
