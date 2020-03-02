package com.danielpm1982.helloWorldWebSpringBoot.controller;
import com.danielpm1982.helloWorldWebSpringBoot.entity.Client;
import com.danielpm1982.helloWorldWebSpringBoot.exception.MyException;
import com.danielpm1982.helloWorldWebSpringBoot.repository.HelloWorldRepositorySpringDataInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    HelloWorldRepositorySpringDataInterface helloWorldRepositorySpringDataInterface;
    @GetMapping("/{email}")
    public ResponseEntity getClient(@PathVariable("email") String email) {
        Client foundClient = null;
        try {
            foundClient = helloWorldRepositorySpringDataInterface.findByEmail(email);
            return ResponseEntity.ok(foundClient);
        } catch (MyException e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Client found for email: "+email+" ! Try again with another email !");
        }
    }
    @GetMapping("/")
    public ResponseEntity getClient() {
        List<Client> allClients = null;
        allClients = helloWorldRepositorySpringDataInterface.findAll();
        if(allClients!=null&&!allClients.isEmpty()){
            return ResponseEntity.ok(allClients);
        } else{
            return ResponseEntity.ok("Database is empty ! No Clients found !");
        }
    }
}
