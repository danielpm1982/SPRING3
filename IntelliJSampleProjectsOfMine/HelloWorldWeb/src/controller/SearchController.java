package controller;
import entity.Client;
import repository.HelloWorldRepositoryInterface;
import repository.HelloWorldRepositoryJDBC;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/searchClient")
public class SearchController extends HttpServlet {
    protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Get one of the following options of "repo", from the servletContext, according to the HelloWorldRepository you've enabled at the InitializerController options (in-memory, JDBC or JPA). Leave the other types disabled (commented).
//        HelloWorldRepositoryInterface helloWorldRepositoryInterface = InitializerController.getRepoInstanceInMemory(req); //getting the "repo" instance dependency from the servletContext.

        HelloWorldRepositoryInterface helloWorldRepositoryInterface = InitializerController.getRepoInstanceJDBC(req); //if the JDBC repo is to be used, please enable both the openResources as the closeResources lines below. If the in-memory repo above is to be used, comment them.
        ((HelloWorldRepositoryJDBC)helloWorldRepositoryInterface).openResources();

        String email = req.getParameter("email");
        RequestDispatcher rd;
        try {
            Client foundClient = helloWorldRepositoryInterface.getClient(email);
            req.setAttribute("foundClient", foundClient);
            req.setAttribute("allClients", helloWorldRepositoryInterface.getClients());
            rd = req.getRequestDispatcher("result.jsp");
        } catch (Exception e) {
            req.setAttribute("searchError", e.getMessage());
            rd = req.getRequestDispatcher("/");
        }

        ((HelloWorldRepositoryJDBC)helloWorldRepositoryInterface).closeResources();

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
Servlet intended to receive, as a request parameter, the email of the Client and use the injected
"repo" dependency to search for that Client at the Repository (and associated DB). The foundClient
is returned to this servlet and later to the view (result.jsp) if no exceptions occur (for instance,
if it doesn't happen to a Client not to be found for that email). If the exception occurs, then the
application flux is forwarded to the initial page (index.html) again, with an error message to be
displayed at the form.
*/
