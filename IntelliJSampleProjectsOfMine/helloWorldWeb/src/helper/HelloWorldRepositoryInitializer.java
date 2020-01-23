package helper;
import repository.HelloWorldRepositoryInMemory;
import repository.HelloWorldRepositoryJDBC;
import repository.HelloWorldRepositoryJPA;
import javax.servlet.http.HttpServletRequest;

public class HelloWorldRepositoryInitializer{
//Initializing helper class for choosing the HelloWorldRepository and adding it to the servletContext for rest of the app to use (the same Repository instance).
//Controllers can then just call one of these static get methods for getting the same instance "repo", already created and initialized here.
//Similar to what Spring does when initializing @Repository beans for later dependency injection elsewhere in the app.
    public static HelloWorldRepositoryInMemory setRepoInstanceInMemory(HttpServletRequest req){
        HelloWorldRepositoryInMemory helloWorldRepositoryInMemory = new HelloWorldRepositoryInMemory();
        req.getServletContext().setAttribute("repo", helloWorldRepositoryInMemory);
        return helloWorldRepositoryInMemory;
    }
    public static HelloWorldRepositoryJDBC setRepoInstanceJDBC(HttpServletRequest req){
        HelloWorldRepositoryJDBC helloWorldRepositoryJDBC = new HelloWorldRepositoryJDBC();
        req.getServletContext().setAttribute("repo", helloWorldRepositoryJDBC);
        return helloWorldRepositoryJDBC;
    }
    public static HelloWorldRepositoryJPA setRepoInstanceJPA(HttpServletRequest req){
        HelloWorldRepositoryJPA helloWorldRepositoryJPA = new HelloWorldRepositoryJPA();
        req.getServletContext().setAttribute("repo", helloWorldRepositoryJPA);
        return helloWorldRepositoryJPA;
    }
}

/*
Helper class intended to instantiate and initialize a HelloWorldRepository instance (Database) and
add it to the servletContext of the app, using the attribute name: "repo".
The methods of any of these "repos" should be statically called from the Controller servlets, returning
the requested and concrete HelloWorldRepository to be used.
The scope is servletContext, or application context, and, as such, the same HelloWorldRepository
instance is managed at the application level:
- in the case of the in-memory type, until the application (server) is restarted or the HelloWorldRepository
is re-associated to the same in-memory type or to another HelloWorldRepository type, set then to the same
application "repo" attribute. If any of these occur, the data is lost;
- in the case of both the JDBC and JPA/Hibernate types, the data is persisted at a physical database. Even
if the "repo" instances are changed, the data persists.
*/
