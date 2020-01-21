<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>HelloWorldWeb</title>
        <link href="resources/css/css.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Welcome</h1>
        <form method="get" action="form"  id="persistenceTypeForm">
            <label for="persistenceType" id="persistenceTypeLabel">Select the persistence type to be used at this web app:</label><br><br>
            <select name="persistenceType" id="persistenceType" required>
                <option value="" selected>SELECT</option>
                <option value="in-memory">In-Memory</option>
                <option value="jdbc">JDBC</option>
                <option value="jpa-hibernate">JPA-Hibernate</option>
            </select>
            <div class="inputSubmit">
                <input type="submit" value="Go to Form">
            </div>
        </form>
        <footer id="index">
            This code is available at the public github repo:<br>
            <a href="https://github.com/danielpm1982/SPRING3/tree/master/IntelliJSampleProjectsOfMine/helloWorldWeb">
                https://github.com/danielpm1982/SPRING3/tree/master/IntelliJSampleProjectsOfMine/helloWorldWeb</a><br><br>
            Developed by:<br>Daniel Pinheiro<br>
            <a href="http://www.danielpm1982.com">http://www.danielpm1982.com</a><br>
            <a href="mailto:danielpm1982.com@domainsbyproxy.com">danielpm1982.com@domainsbyproxy.com</a><br>
        </footer>
    </body>
</html>
