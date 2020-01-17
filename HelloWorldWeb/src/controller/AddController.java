package controller;
import model.Client;
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
        HelloWorldRepositoryInterface helloWorldRepositoryInterface = InitializerController.getRepoInstance(req); //injecting the "repo" instance dependency already available at the servletContext.
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Client mockClient = new Client(-1, name, email);
        RequestDispatcher rd;
        try{
            Client addedClient = helloWorldRepositoryInterface.addClient(mockClient);
            req.setAttribute("addingError", null);
            req.setAttribute("addedClient", addedClient);
            req.setAttribute("allClients", helloWorldRepositoryInterface.getClients());
            rd = req.getRequestDispatcher("result.jsp");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            req.setAttribute("addingError", e.getMessage());
            req.setAttribute("addedClient", null);
            req.setAttribute("allClients", helloWorldRepositoryInterface.getClients());
            rd = req.getRequestDispatcher("/");
        }
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
Servlet intended to receive as request parameters the name and email of the Client and use
the injected "repo" dependency to add that Client to the Repository. At the Repository, the
unique id is generated and the addedClient returned to this servlet and later to the result.jsp
view if no exceptions occur (for instance, add more than one Client with the same email). If
the exception occurs, then it's forwarded to the initial index.html again with an error message
to be displayed at the input form.
*/
