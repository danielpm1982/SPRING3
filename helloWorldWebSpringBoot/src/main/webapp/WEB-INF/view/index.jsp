<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>HelloWorldWeb</title>
        <link href="css/css.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Welcome</h1>
        <div class="middle">
            <a class="myLink" href="${pageContext.request.contextPath}/form">Form</a>
        </div>
        <div class="middle">
            <a class="myLink" href="${pageContext.request.contextPath}/api/">Restful API (All Clients)</a>
        </div>
        <footer id="index">
            This code is available at the public github repo:<br>
            <a href="https://github.com/danielpm1982/SPRING3/tree/master/IntelliJSampleProjectsOfMine/helloWorldWebSpringBoot">
                https://github.com/danielpm1982/SPRING3/tree/master/IntelliJSampleProjectsOfMine/helloWorldWebSpringBoot</a><br><br>
            Developed by:<br>Daniel Pinheiro<br>
            <a href="http://www.danielpm1982.com">http://www.danielpm1982.com</a><br>
            <a href="mailto:danielpm1982.com@domainsbyproxy.com">danielpm1982.com@domainsbyproxy.com</a><br>
        </footer>
    </body>
</html>
