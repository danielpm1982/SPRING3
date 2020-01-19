package repository;
import entity.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HelloWorldRepositoryJDBC implements HelloWorldRepositoryInterface {
    private final String DATABASE_URL;
    private final String USER;
    private final String PASSWORD;
    private Connection conn;
    private Statement statement;
    private PreparedStatement preparedStatement;
    public HelloWorldRepositoryJDBC(){
        DATABASE_URL = "jdbc:mysql://localhost:3306/scheme1?verifyServerCertificate=false";
        USER = "root";
        PASSWORD = "root";
        conn = null;
        statement = null;
        preparedStatement = null;
    }
    @Override
    public void openResources(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
            statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch(SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
    @Override
    public void closeResources(){
        try{
            if(conn!=null){
                conn.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
        } catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
    @Override
    public List<Client> getClients() throws Exception{
        List<Client> clientList = new ArrayList<>();
        ResultSet rs = executeQuery("select * from client");
        while (rs!=null&&rs.next()) {
            long idTemp = rs.getLong("id");
            String nameTemp = rs.getString("name");
            String emailTemp = rs.getString("email");
            clientList.add(new Client(idTemp, nameTemp, emailTemp));
        }
        return clientList;
    }
    @Override
    public Client getClient(String email) throws Exception{
        Client client = null;
        ResultSet rs = executeQuery("select * from client c where c.email=?", email);
        if (rs!=null&&rs.next()) {
            long idTemp = rs.getLong("id");
            String nameTemp = rs.getString("name");
            String emailTemp = rs.getString("email");
            client = new Client(idTemp, nameTemp, emailTemp);
        } else{
            throw new Exception("No Client found at the Database for the email="+email+" ! Email not found ! Try again with another email !");
        }
        return client;
    }
    private Client getClient(String email, boolean ignoreEmptyResults) throws Exception{
        Client client = null;
        ResultSet rs = executeQuery("select * from client c where c.email=?", email);
        if (rs!=null&&rs.next()) {
            long idTemp = rs.getLong("id");
            String nameTemp = rs.getString("name");
            String emailTemp = rs.getString("email");
            client = new Client(idTemp, nameTemp, emailTemp);
        } else{
            if(ignoreEmptyResults){
                //ignores empty rs. Does not throw the Exception for the empty rs in order to be able to return null to the calling method and not leave directly to the Controller.
            } else{
                throw new Exception("No Client found at the Database for the email="+email+" ! Email not found ! Try again with another email !");
            }
        }
        return client;
    }
    @Override
    public Client addClient(Client mockClient) throws Exception {
        Client client = getClient(mockClient.getEmail(), true);
        if(client!=null){
            throw new Exception("A Client already exists at the Database for the email: "+mockClient.getEmail()+" ! Try again with a different email address ! Client not added !");
        } else{
            insert("insert into client(name, email) values(?, ?)", mockClient.getName(), mockClient.getEmail());
            client = getClient(mockClient.getEmail(), true);
            if(client==null){
                throw new Exception("No Client found at the Database for the email: "+mockClient.getEmail()+" after the adding process ! Failure at the adding process ! Client not added !");
            }
        }
        return client;
    }
    private void insert(String insertSQL, String... argsToPreparedStatementSQL){
        try{
            preparedStatement = createPreparedStatement(insertSQL);
            for(int i=0; i<argsToPreparedStatementSQL.length; i++){
                preparedStatement.setString(i+1, argsToPreparedStatementSQL[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Failed to insert!");
        }
    }
    private ResultSet executeQuery(String query){
        ResultSet rs = null;
        try{
            rs = statement.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return rs;
    }
    private ResultSet executeQuery(String query, String... argsToPreparedStatementSQL){
        ResultSet rs = null;
        try{
            preparedStatement = createPreparedStatement(query);
            for(int i=0; i<argsToPreparedStatementSQL.length; i++){
                preparedStatement.setString(i+1, argsToPreparedStatementSQL[i]);
            }
            rs = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return rs;
    }
    private PreparedStatement createPreparedStatement(String preparedStatementSQL){
        try{
            preparedStatement = conn.prepareStatement(preparedStatementSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        return preparedStatement;
    }
}

/*
JDBC-based repository, connected to a MySQL Database, from whose data the app can:
- mount back Client instances to memory, and show the list of Client instances with data
already persisted at the Database;
- search for a specific Client instance data, using the email as a unique search key,
and get the respective instance mounted back to memory that data;
- add new Client data, from new Client instances, to the Database connected to this repository.

For testing, please first create the Database, using the MySQL script available at the resources
folder, in order for this app to be able to connect with it (through the mysql-connector-java-8.0.18
driver available at the lib).
*/
