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

@WebServlet("/searchClient")
public class SearchController extends HttpServlet {
    protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HelloWorldRepositoryInterface helloWorldRepositoryInterface = (HelloWorldRepositoryInterface)req.getServletContext().getAttribute("repo");
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
Servlet intended to receive, as a request parameter, the email of the Client and use the
servletContext "repo" instance, previously set by the HelloWorldRepositoryInitializer
(from the FormController), in order to search for that corresponding Client instance at the
Repository (and associated DB).
The foundClient is then returned to this servlet and later to the view (result.jsp), if no exceptions
occur (for instance, if it doesn't happen that a Client is not found for that email).
Otherwise, if the exception occurs, the application flux is forwarded to the form page again, instead of
to the result page, with the message error String mapped through the "searchError" request attribute, so
that it is displayed to the final user.
Only MyException thrown Exceptions are left to be managed at the Controller level. All other exceptions
are catched and managed internally at the code (at the Repositories' code). The final user should only
view MyException-type Exceptions. Other types are displayed only at the console view of the server.
*/
