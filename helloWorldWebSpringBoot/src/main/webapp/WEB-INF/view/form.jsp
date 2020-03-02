<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>Client Registration</title>
    <link href="css/css.css" rel="stylesheet" type="text/css">
  </head>
  <body>
    <h1>Client Registration</h1>
    <form:form action="${pageContext.request.contextPath}/addClient" modelAttribute="addClientModelAttribute">
        <c:if test="${addClientError != null}">
            <span class=errors>${addClientError}</span>
        </c:if>
        <form:errors path="name" cssClass="errors" />
        <form:errors path="email" cssClass="errors" />
        <div class="table">
            <div class="formRow">
                <div class="formCell formCellLeft"><form:label path="name">Name</form:label></div>
                <div class="formCell formCellRight"><form:input placeholder="type your name" path="name" required="required" /></div>
            </div>
            <div class="formRow">
                <div class="formCell formCellLeft"><form:label path="email">Email</form:label></div>
                <div class="formCell formCellRight"><form:input placeholder="type your email" path="email" required="required" /></div>
            </div>
        </div>
        <div class="inputSubmit">
            <input type="submit" value="Add Client">
        </div>
    </form:form>
    <h1>Client Search</h1>
    <form:form action="${pageContext.request.contextPath}/searchClient" modelAttribute="searchClientModelAttribute">
        <c:if test="${searchClientError != null}">
            <span class=errors>${searchClientError}</span>
        </c:if>
        <form:errors path="email" cssClass="errors" />
        <div class="table">
            <div class="formRow">
                <div class="formCell formCellLeft"><form:label path="email">Email</form:label></div>
                <div class="formCell formCellRight"><form:input placeholder="type your email to search" path="email" required="required" /></div>
            </div>
        </div>
        <div class="inputSubmit">
            <input type="submit" value="Search Client">
        </div>
    </form:form>
    <footer>
      <a class="myLink" href="${pageContext.request.contextPath}/">Home</a>
    </footer>
  </body>
</html>
