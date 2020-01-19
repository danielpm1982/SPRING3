package repository;
import entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class HelloWorldRepositoryJPA implements HelloWorldRepositoryInterface {
    private static SessionFactory sessionFactory;
    public HelloWorldRepositoryJPA(){
    }
    @Override
    public void openResources(){
        if(sessionFactory==null||sessionFactory.isClosed()) {
            sessionFactory = new Configuration().addAnnotatedClass(Client.class).configure("hibernate.cfg.xml").buildSessionFactory();
//				truncateAllTables(factory);
        }
    }
    @Override
    public void closeResources(){
        if(sessionFactory!=null&&sessionFactory.isOpen()){
            sessionFactory.close();
        }
    }
    public static boolean isInitialized() {
        return (sessionFactory!=null&&sessionFactory.isOpen());
    }
    @Override
    public List<Client> getClients() throws Exception{
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            List<Client> allClientsList = session.createQuery("from Client c", Client.class).getResultList();
            session.getTransaction().commit();
            return allClientsList;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        } finally {
            if(session.isOpen()) {
                session.close();
            }
        }
    }
    @Override
    public Client getClient(String email) throws Exception{
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
//            String hql = "from Client c where c.email like '%"+email+"%'";
            String hql = "from Client c where c.email='"+email+"'";
            Client client = session.createQuery(hql, Client.class).getSingleResult();
            session.getTransaction().commit();
            if(client!=null){
                return client;
            } else{
                throw new Exception("No Client found at the Database for the email="+email+" ! Email not found ! Try again with another email !");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        } finally {
            if(session.isOpen()) {
                session.close();
            }
        }
    }
    private Client getClient(String email, boolean ignoreEmptyResults) throws Exception{
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
//            String hql = "from Client c where c.email like '%"+email+"%'";
            String hql = "from Client c where c.email='"+email+"'";
            Client client = session.createQuery(hql, Client.class).getSingleResult();
            session.getTransaction().commit();
            if(client!=null){
                return client;
            } else{
                if(ignoreEmptyResults){
                    //ignores empty rs. Does not throw the Exception for the empty rs in order to be able to return null to the calling method and not leave directly to the Controller.
                    return null;
                } else{
                    throw new Exception("No Client found at the Database for the email="+email+" ! Email not found ! Try again with another email !");
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        } finally {
            if(session.isOpen()) {
                session.close();
            }
        }
    }
    @Override
    public Client addClient(Client mockClient) throws Exception {
        Session session = null;
        try {
            //checking if already exists
            Client checkClient = getClient(mockClient.getEmail(), true);
            if(checkClient!=null){
                throw new Exception("A Client already exists at the Database for the email: "+mockClient.getEmail()+" ! Try again with a different email address ! Client not added !");
            } else{
                //saving at the DB and getting the generated identifier (Id)
                session = sessionFactory.getCurrentSession();
                session.getTransaction().begin();
                session.save(mockClient);
                session.getTransaction().commit();
                //checking if saved
                Client client = getClient(mockClient.getEmail(), true);
                if(client==null){
                    throw new Exception("No Client found at the Database for the email: "+mockClient.getEmail()+" after the adding process ! Failure at the adding process ! Client not added !");
                } else{
                    return client;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        } finally {
            if(session.isOpen()) {
                session.close();
            }
        }
    }
}
