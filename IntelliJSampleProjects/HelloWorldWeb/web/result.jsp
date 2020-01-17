<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Client Registration Result</title>
    <link rel="stylesheet" type="text/css" href="css.css">
  </head>
  <body>
    <c:if test="${not empty addedClient}">
      <h2>Client Added Successfully:</h2>
      <ul class="table">
        <li class="formRow"><div class="formCell">CLIENT_ID</div><div class="formCell">NAME</div><div class="formCell">EMAIL</div></li>
        <li class="formRow"><div class="formCell">${addedClient.id}</div><div class="formCell">${addedClient.name}</div><div class="formCell">${addedClient.email}</div></li>
      </ul>
    </c:if>
    <c:if test="${not empty foundClient}">
      <h2>Client Found:</h2>
      <ul class="table">
        <li class="formRow"><div class="formCell">CLIENT_ID</div><div class="formCell">NAME</div><div class="formCell">EMAIL</div></li>
        <li class="formRow"><div class="formCell">${foundClient.id}</div><div class="formCell">${foundClient.name}</div><div class="formCell">${foundClient.email}</div></li>
      </ul>
    </c:if>
    <h2>All Clients:</h2>
    <ul class="table">
      <li class="formRow"><div class="formCell">CLIENT_ID</div><div class="formCell">NAME</div><div class="formCell">EMAIL</div></li>
      <c:forEach items="${allClients}" var="client" varStatus="status">
        <li class="formRow"><div class="formCell">${client.id}</div><div class="formCell">${client.name}</div><div class="formCell">${client.email}</div></li>
      </c:forEach>
    </ul>
    <footer>
      <a class="myLink" href="/web_war_exploded">Home</a>
    </footer>
  </body>
</html>
