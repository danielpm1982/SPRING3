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

@WebServlet("/searchClient")
public class SearchController extends HttpServlet {
    protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Get *ONLY ONE* of the following options of "repo" (in-memory, JDBC or JPA), stored at the servletContext, using the HelloWorldRepositoryInitializer respective static get method.
//        HelloWorldRepositoryInterface helloWorldRepositoryInterface = HelloWorldRepositoryInitializer.getRepoInstanceInMemory(req);
//        HelloWorldRepositoryInterface helloWorldRepositoryInterface = HelloWorldRepositoryInitializer.getRepoInstanceJDBC(req);
        HelloWorldRepositoryInterface helloWorldRepositoryInterface = HelloWorldRepositoryInitializer.getRepoInstanceJPA(req);

        helloWorldRepositoryInterface.openResources();
        String email = req.getParameter("email");
        RequestDispatcher rd;
        try {
            Client foundClient = helloWorldRepositoryInterface.getClient(email);
            req.setAttribute("foundClient", foundClient);
            req.setAttribute("allClients", helloWorldRepositoryInterface.getClients());
            rd = req.getRequestDispatcher("result.jsp");
        } catch (Exception e) {
            req.setAttribute("searchError", e.getMessage());
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
Servlet intended to receive, as a request parameter, the email of the Client and use the injected
"repo" dependency to search for that Client at the Repository (and associated DB). The foundClient
is returned to this servlet and later to the view (result.jsp) if no exceptions occur (for instance,
if it doesn't happen to a Client not to be found for that email). If the exception occurs, then the
application flux is forwarded to the initial page (index.html) again, with an error message to be
displayed at the form.
*/
