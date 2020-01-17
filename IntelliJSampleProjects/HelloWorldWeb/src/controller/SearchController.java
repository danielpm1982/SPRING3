package controller;
import model.Client;
import repository.HelloWorldRepository;
import repository.HelloWorldRepositoryInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchClient")
public class SearchController extends HttpServlet {
    protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HelloWorldRepositoryInterface helloWorldRepositoryInterface = InitializerController.getRepoInstance(req); //injecting the "repo" instance dependency already available at the servletContext.
        String email = req.getParameter("email");
        RequestDispatcher rd;
        try {
            Client foundClient = helloWorldRepositoryInterface.getClient(email);
            req.setAttribute("searchError", null);
            req.setAttribute("foundClient", foundClient);
            req.setAttribute("allClients", helloWorldRepositoryInterface.getClients());
            rd = req.getRequestDispatcher("result.jsp");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            req.setAttribute("searchError", e.getMessage());
            req.setAttribute("foundClient", null);
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
Servlet intended to receive as request parameter the email of the Client and use the injected
"repo" dependency to search for that Client at the Repository. The foundClient is returned to
this servlet and later to the result.jsp view if no exceptions occur (for instance, if no Client
is found for that email). If the exception occurs, then it's forwarded to the initial index.html
again with an error message to be displayed at the input form.
*/
