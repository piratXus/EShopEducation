<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.10.2016
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>

<form action="<c:url value='/j_spring_security_logout'/>" method="post">
    <input type="hidden" name="_csrf.parameterName" value="_csrf.token"/>
    <input type="submit" id="logout" name="logout" value="Log out">
</form>
