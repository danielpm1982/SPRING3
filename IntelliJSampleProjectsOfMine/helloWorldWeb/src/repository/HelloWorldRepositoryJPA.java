package repository;
import entity.Client;
import exception.MyException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.NoResultException;
import java.util.List;

public class HelloWorldRepositoryJPA implements HelloWorldRepositoryInterface {
    private static SessionFactory sessionFactory;
    public HelloWorldRepositoryJPA(){
    }
    @Override
    public void openResources(){
        if(sessionFactory==null||sessionFactory.isClosed()) {
            sessionFactory = new Configuration().addAnnotatedClass(Client.class).configure("hibernate.cfg.xml").buildSessionFactory();
        }
    }
    @Override
    public void closeResources(){
        if(sessionFactory!=null&&sessionFactory.isOpen()){
            sessionFactory.close();
        }
    }
    @Override
    public List<Client> getClients() throws Exception{
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        try {
            List<Client> allClientsList = session.createQuery("from Client c", Client.class).getResultList();
            return allClientsList;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new MyException("Internal error getting Clients !");
        } finally {
            if(session!=null && session.isOpen()) {
                session.close();
            }
        }
    }
    @Override
    public Client getClient(String email) throws Exception{
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        try {
//            String hql = "from Client c where c.email like '%"+email+"%'";
            String hql = "from Client c where c.email='"+email+"'";
            Client client = session.createQuery(hql, Client.class).getSingleResult();
            return client;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            if(e instanceof NoResultException){
                throw new MyException("No Client found at the Database for the email="+email+" ! Email not found ! Try again with another email !");
            }
            return null;
        } finally {
            if(session!=null && session.isOpen()) {
                session.close();
            }
        }
    }
    @Override
    public Client addClient(Client mockClient) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        try {
            //checking if already exists
            String hql = "from Client c where c.email='"+mockClient.getEmail()+"'";
            Client checkClient = null;
            try {
                checkClient = session.createQuery(hql, Client.class).getSingleResult();
            } catch (NoResultException noResult){
                //doesn't do anything and continue...
            }
            if (checkClient != null) {
                throw new MyException("A Client already exists at the Database for the email: " + mockClient.getEmail() + " ! Try again with a different email address ! Client not added !");
            } else {
                //saving at the DB and getting the generated identifier (Id)
                session.save(mockClient);
                session.getTransaction().commit();
                //checking if saved
                Client client = null;
                try {
                    session = sessionFactory.getCurrentSession();
                    session.getTransaction().begin();
                    client = session.createQuery(hql, Client.class).getSingleResult();
                } catch (NoResultException noResult){
                    throw new MyException("No Client found at the Database for the email: " + mockClient.getEmail() + " after the adding process ! Failure at the adding process ! Client not added !");
                }
                return client;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            if(e instanceof MyException){
                throw e;
            }
            return null;
        } finally {
            if(session!=null && session.isOpen()) {
                session.close();
            }
        }
    }
    @Override
    public String getInfo() {
        return "The Repository selected for persistence is of type JPA/Hibernate.";
    }
}

/*
JPA-based repository, connected to a MySQL Database, from whose data the app can:
- mount back Client instances to memory, or show the list of Client instances, using
the data already persisted at the Database;
- search for a specific Client instance, using the email as a unique search key,
and get the respective mounted back instance using the data already persisted
at the Database;
- add new Client data, from new Client instances, to the Database connected to this repository.

For testing, please first create the Database, using the MySQL script available at the resources
folder, in order to this app to be able to connect with it (through the mysql-connector-java-8.0.18
driver available at the lib).
*/
