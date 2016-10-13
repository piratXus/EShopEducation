<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.10.2016
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Login page</title>
</head>
<body>
        <h3>${error}</h3>
    <form action="<c:url value='/j_spring_security_check'/>" method="post">
        <label>Username
        <input type="text" name="j_username" value="" placeholder="Username or Email"></label>
        <label>Password
        <input type="password" name="j_password" value="" placeholder="Password"></label>
        <input type="submit" value="Access" name="submit">
    </form>
</body>
</html>
