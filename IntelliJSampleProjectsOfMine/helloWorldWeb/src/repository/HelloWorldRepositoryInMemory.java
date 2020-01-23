package repository;
import entity.Client;
import java.util.ArrayList;
import java.util.List;

public class HelloWorldRepositoryInMemory implements HelloWorldRepositoryInterface {
    private long id;
    private List<Client> clientInMemoryDB;
    public HelloWorldRepositoryInMemory() {
        this.id=1000;
        this.clientInMemoryDB = new ArrayList<>();
    }
    @Override
    public void openResources(){
    }
    @Override
    public void closeResources(){
    }
    @Override
    public List<Client> getClients() {
        return clientInMemoryDB;
    }
    @Override
    public Client getClient(String email) throws Exception{
        Client client = clientInMemoryDB.stream().filter(x->x.getEmail().compareTo(email)==0).findFirst().orElse(null);
        if(client==null){
            throw new Exception("No Client found at the Database for the email="+email+" ! Email not found ! Try again with another email !");
        }
        return client;
    }
    @Override
    public Client addClient(Client mockClient) throws Exception {
        Client clientAlreadyExistent = clientInMemoryDB.stream().filter(x->x.getEmail().compareTo(mockClient.getEmail())==0).findFirst().orElse(null);
        if(clientAlreadyExistent!=null){
            throw new Exception("A Client already exists at the Database for the email: "+mockClient.getEmail()+" ! Try again with a different email address ! Client not added !");
        } else{
            Client client = new Client(id++, mockClient.getName(), mockClient.getEmail());
            clientInMemoryDB.add(client);
            if(!clientInMemoryDB.contains(client)){
                throw new Exception("No Client found at the Database for the email: "+mockClient.getEmail()+" after the adding process ! Failure at the adding process ! Client not added !");
            } else{
                return client;
            }
        }
    }
    @Override
    public String getInfo() {
        return "The Repository selected for persistence is of type in-memory.";
    }
}

/*
In-memory repository, based on a List of Clients, through which one can get all Client instances,
a specific Client instance using the email as the unique search key or add new Client instances to
the repository.
*/
