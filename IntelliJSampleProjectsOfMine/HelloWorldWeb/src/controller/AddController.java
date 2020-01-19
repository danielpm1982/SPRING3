package controller;
import entity.Client;
import helper.HelloWorldRepositoryInitializer;
import repository.HelloWorldRepositoryInterface;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addClient")
public class AddController extends HttpServlet {
    protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Get *ONLY ONE* of the following options of "repo" (in-memory, JDBC or JPA), stored at the servletContext, using the HelloWorldRepositoryInitializer respective static get method.
//        HelloWorldRepositoryInterface helloWorldRepositoryInterface = HelloWorldRepositoryInitializer.getRepoInstanceInMemory(req);
//        HelloWorldRepositoryInterface helloWorldRepositoryInterface = HelloWorldRepositoryInitializer.getRepoInstanceJDBC(req);
        HelloWorldRepositoryInterface helloWorldRepositoryInterface = HelloWorldRepositoryInitializer.getRepoInstanceJPA(req);

        helloWorldRepositoryInterface.openResources();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Client mockClient = new Client(-1, name, email);
        RequestDispatcher rd;
        try{
            Client addedClient = helloWorldRepositoryInterface.addClient(mockClient);
            req.setAttribute("addedClient", addedClient);
            req.setAttribute("allClients", helloWorldRepositoryInterface.getClients());
            rd = req.getRequestDispatcher("result.jsp");
        } catch (Exception e) {
            req.setAttribute("addingError", e.getMessage());
            rd = req.getRequestDispatcher("/form");
        }
        helloWorldRepositoryInterface.closeResources();
        rd.forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req,resp);
    }
}

/*
Servlet intended to receive, as request parameters, the name and email of the Client and use
the injected "repo" dependency to add that mock Client to the Repository. At the Repository, the
unique id is generated and the addedClient (now a real Client) returned to this servlet and
later to the view (result.jsp), if no exceptions occur (for instance, if no request is sent to add
a Client with an already existing email - emails are unique, although the PK at the DB is the id).
Except for the in-memory repo (which uses a list-based DB), the other repo types are linked to a
MySQL DB for persistence.
If any exception occurs, then the application flux is forwarded to the initial page (index.html)
again, with an error message to be displayed at the form.
*/
