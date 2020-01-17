package repository;
import model.Client;
import java.util.List;

public interface HelloWorldRepositoryInterface {
    public List<Client> getClients();
    public Client getClient(String email) throws Exception;
    public Client addClient(Client mockClient) throws Exception;
}
