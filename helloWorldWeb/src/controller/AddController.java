package controller;
import entity.Client;
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
        HelloWorldRepositoryInterface helloWorldRepositoryInterface = (HelloWorldRepositoryInterface)req.getServletContext().getAttribute("repo");
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
            rd = req.getRequestDispatcher("form.jsp");
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
Servlet intended to receive, as request parameters, the name and the email of the Client and use the
servletContext "repo" instance, previously set by the HelloWorldRepositoryInitializer
(from the FormController), in order to add that mock Client to the Repository (and associated DB).
At the Repository, the unique id is generated and the addedClient (now a complete Client) returned
to this servlet and later to the view (result.jsp), if no exceptions occur (for instance, if no request
is sent to add a Client with an already existing email - emails are unique, although the PK at the DB
is the id).
Otherwise, if the exception occurs, the application flux is forwarded to the form page again, instead of
to the result page, with the message error String mapped through the "searchError" request attribute, so
that it is displayed to the final user.
Only MyException thrown Exceptions are left to be managed at the Controller level. All other exceptions
are catched and managed internally (at the Repositories' code). The final user should only
view MyException-type Exceptions. Other types are displayed only at the console view of the server.
*/
