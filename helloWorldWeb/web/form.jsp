<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Client Registration</title>
    <link href="resources/css/css.css" rel="stylesheet" type="text/css">
  </head>
  <body>
    <h1>Client Registration</h1>
    <form method="post" action="/helloWorldWeb/addClient">
      <c:if test="${not empty addingError}">
        <div class="error">
          <c:out value="${addingError}" />
        </div>
      </c:if>
      <div class="table">
        <div class="formRow">
          <div class="formCell formCellLeft"><label for="name">Client Name</label></div>
          <div class="formCell formCellRight"><input type="text" placeholder="type your name" name="name" id="name" required /></div>
        </div>
        <div class="formRow">
          <div class="formCell formCellLeft"><label for="email">Email</label></div>
          <div class="formCell formCellRight"><input type="text" placeholder="type your email" name="email" id="email" required /></div>
        </div>
      </div>
      <div class="info">
        <c:out value="${repo.info}" />
      </div>
      <div class="inputSubmit">
        <input type="submit" value="Add Client">
      </div>
    </form>
    <h1>Client Search</h1>
    <form method="get" action="/helloWorldWeb/searchClient">
      <c:if test="${not empty searchError}">
        <div class="error">
          <c:out value="${searchError}" />
        </div>
      </c:if>
      <div class="table">
        <div class="formRow">
          <div class="formCell formCellLeft"><label for="emailToSearch">Email</label></div>
          <div class="formCell formCellRight"><input type="text" placeholder="type your email to search" name="email" id="emailToSearch" required /></div>
        </div>
      </div>
      <div class="info">
        <c:out value="${repo.info}" />
      </div>
      <div class="inputSubmit">
        <input type="submit" value="Search Client">
      </div>
    </form>
    <footer>
      <a class="myLink" href="/helloWorldWeb">Home</a>
    </footer>
  </body>
</html>
