package repository;
import entity.Client;
import java.util.List;

public interface HelloWorldRepositoryInterface {
    public List<Client> getClients() throws Exception;
    public Client getClient(String email) throws Exception;
    public Client addClient(Client mockClient) throws Exception;
    public void openResources();
    public void closeResources();
}

/*
Interface for the many types of Repositories implemented (in-memory, JDBC, JPA, etc),
used form the Controllers to manage the entity Client.
*/
