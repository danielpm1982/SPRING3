package repository;
import model.Client;
import java.util.ArrayList;
import java.util.List;

public class HelloWorldRepository implements HelloWorldRepositoryInterface {
    private long id;
    private List<Client> clientInMemoryDB;
    public HelloWorldRepository() {
        this.id=1000;
        this.clientInMemoryDB = new ArrayList<>();
    }
    @Override
    public List<Client> getClients() {
        return clientInMemoryDB;
    }
    @Override
    public Client getClient(String email) throws Exception{
        Client client = clientInMemoryDB.stream().filter(x->x.getEmail()==email).findFirst().orElse(null);
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
                throw new Exception("No Client found at the Database for the email: "+mockClient.getEmail()+" after adding process ! Failure at the adding process ! Client not added !");
            } else{
                return client;
            }
        }
    }

}
