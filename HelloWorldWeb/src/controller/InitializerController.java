package controller;
import repository.HelloWorldRepository;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/web_war_exploded")
public class InitializerController extends HttpServlet {
    protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InitializerController.getRepoInstance(req); //initializing the HelloWorldRepository and adding to servletContext for rest of the app to use the same Repository instance. Other controllers can then just call this same method for getting the same instance "repo" already created and initialized. Similar to what Spring does when initializing beans for later dependency injection elsewhere in the app.
        RequestDispatcher rd = req.getRequestDispatcher("index.html");
        rd.forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req,resp);
    }
    public static HelloWorldRepository getRepoInstance(HttpServletRequest req){
        HelloWorldRepository helloWorldRepository = (HelloWorldRepository)req.getServletContext().getAttribute("repo");
        if(helloWorldRepository==null){
            helloWorldRepository = new HelloWorldRepository();
            req.getServletContext().setAttribute("repo", helloWorldRepository);
        }
        return helloWorldRepository;
    }
}

/*
Servlet intended to instantiate and initialize the "repo" instance (Database) and add it to the
servletContext of the app. Before any other servlet or service is called. Then returns to the index.html.

This app is a very simple one that uses simple JEE features as Servlets and JSPs to manage an in-memory
Repository or DB of Client(long id, String name, String email) instances.

This project can be even more simplified through the use of Spring to manage the beans and dependency
injections, as well as to add other features as Security and Data JPA.

This project has been developed and implemented using IntelliJ Ultimate, JDK 13 and TomCat 9.
Developed by Daniel Pinheiro,
http://danielpm1982.com,
danielpm1982.com@domainsbyproxy.com .

You may use this code for study or for academic purposes only.
This is not supposed to be a commercial application by any means.
This code is available at the public github repo:
*/
