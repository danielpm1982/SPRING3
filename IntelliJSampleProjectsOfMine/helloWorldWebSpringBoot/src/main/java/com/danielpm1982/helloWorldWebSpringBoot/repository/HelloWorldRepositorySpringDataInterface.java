package com.danielpm1982.helloWorldWebSpringBoot.repository;
import com.danielpm1982.helloWorldWebSpringBoot.entity.Client;
import com.danielpm1982.helloWorldWebSpringBoot.exception.MyException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloWorldRepositorySpringDataInterface extends JpaRepository<Client, Long> {
    public default Client findByEmail(String email) throws MyException{
        Client foundClient = findAll().stream().filter(x->x.getEmail().compareTo(email)==0).findFirst().orElse(null);
        if(foundClient==null) {
            throw new MyException("No Client found for email: '" + email + "' ! Try again with another email !");
        }
        return foundClient;
    }
    public default Client add(Client mockClient) throws MyException{
        Client foundClient = findAll().stream().filter(x->x.getEmail().compareTo(mockClient.getEmail())==0).findFirst().orElse(null);
        if(foundClient!=null){
            throw new MyException("Client already exists for email: '" + mockClient.getEmail() + "' ! Try again with another email ! Client not added !");
        }
        Client addedClient = save(mockClient);
        if(addedClient==null){
            throw new MyException("Internal failure in adding Client for email: '" + mockClient.getEmail() + "' ! Client not added !");
        }
        return addedClient;
    }
}
