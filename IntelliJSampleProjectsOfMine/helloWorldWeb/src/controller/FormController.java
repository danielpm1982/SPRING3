package controller;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/form")
public class FormController extends HttpServlet {
    protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/form.jsp");
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
This is a welcome servlet for doing any future processing before forwarding to the root initial page.
*/

/*
This is a simple web app that uses JEE features (Servlets, JSPs and JSTL) and multiple options of Repository types
(linked to Databases) for the management of Client(long id, String name, String email) instances.

The in-memory "repo" uses a List<Client>-based DB, while the others use MySQL and a real persistent DB.

This project can be even more simplified, and a lot of code saved, through the use of Spring/SpringBoot Framework,
to manage, at the Application Context, the beans and dependency injections automatically, as well as to turn the
implementation of other features, as Security, Rest Services and Spring Data JPA, much easier.

This project has been developed and implemented using IntelliJ Ultimate, JDK 13 and TomCat 9.
Also, mysql-connector-java-8.0.18 driver as well as JSTL and JPA/Hibernate 2.1/6 libs have been manually added to the
WEB-INF lib folder, as no MAVEN has been used to deal with the import of these dependencies.

Developed by Daniel Pinheiro,
http://danielpm1982.com,
danielpm1982.com@domainsbyproxy.com .

This code is available at the public github repo:
https://github.com/danielpm1982/SPRING3/tree/master/HelloWorldWeb .

You may use this code for study or for academic purposes only.
This is not supposed to be a commercial application by any means.
*/
