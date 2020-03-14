package com.danielpm1982.springboot2healthrecord.configAndBootstrapDataLoad;
import com.danielpm1982.springboot2healthrecord.domain.Person;
import com.danielpm1982.springboot2healthrecord.repository.Db;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DbConfiguration {
    private List<Person> personList;
    public DbConfiguration() {
        this.personList = new ArrayList<>();
    }
    @Scope("singleton")
    @Bean
    public Db db(){
        return new Db(personList);
    }
}
