package com.danielpm1982.helloWorldWebSpringBoot.entity;
import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Email(message="Please type a valid email address !")
    private String email;
    public Client(){}
    public Client(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

//a simple entity Client, manageable through any of the Repository instances. And, in the
// case of JPA Repository, mapped for ORM persistence.
