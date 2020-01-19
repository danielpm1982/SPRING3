package helper;
import repository.HelloWorldRepositoryInMemory;
import repository.HelloWorldRepositoryJDBC;
import repository.HelloWorldRepositoryJPA;
import javax.servlet.http.HttpServletRequest;

public class HelloWorldRepositoryInitializer{
//Initializing helper class for choosing the HelloWorldRepository and adding it to the servletContext for rest of the app to use (the same Repository instance).
//Other controllers can then just call one of these static get methods for getting the same instance "repo", already created and initialized.
//Similar to what Spring does when initializing @Repository beans for later dependency injection elsewhere in the app.
    public static HelloWorldRepositoryInMemory getRepoInstanceInMemory(HttpServletRequest req){
        HelloWorldRepositoryInMemory helloWorldRepositoryInMemory = (HelloWorldRepositoryInMemory)req.getServletContext().getAttribute("repo");
        if(helloWorldRepositoryInMemory==null){
            helloWorldRepositoryInMemory = new HelloWorldRepositoryInMemory();
            req.getServletContext().setAttribute("repo", helloWorldRepositoryInMemory);
        }
        return helloWorldRepositoryInMemory;
    }
    public static HelloWorldRepositoryJDBC getRepoInstanceJDBC(HttpServletRequest req){
        HelloWorldRepositoryJDBC helloWorldRepositoryJDBC = (HelloWorldRepositoryJDBC)req.getServletContext().getAttribute("repo");
        if(helloWorldRepositoryJDBC==null){
            helloWorldRepositoryJDBC = new HelloWorldRepositoryJDBC();
            req.getServletContext().setAttribute("repo", helloWorldRepositoryJDBC);
        }
        return helloWorldRepositoryJDBC;
    }
    public static HelloWorldRepositoryJPA getRepoInstanceJPA(HttpServletRequest req){
        HelloWorldRepositoryJPA helloWorldRepositoryJPA = (HelloWorldRepositoryJPA)req.getServletContext().getAttribute("repo");
        if(helloWorldRepositoryJPA==null){
            helloWorldRepositoryJPA = new HelloWorldRepositoryJPA();
            req.getServletContext().setAttribute("repo", helloWorldRepositoryJPA);
        }
        return helloWorldRepositoryJPA;
    }
}

/*
Helper class intended to instantiate and initialize a "repo" instance (Database) and add it to the
servletContext of the app. Before any other servlet or service is called. It should be statically
called from the servlets, returning the requested HelloWorldRepository.
*/
