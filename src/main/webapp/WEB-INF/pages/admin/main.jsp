<%--
  Created by IntelliJ IDEA.
  User: raks
  Date: 12.10.16
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>Hello Admin!!!</h1>
    <%--<sec:authorize access="isAuthenticated()">--%>
        <%@ include file="/WEB-INF/pages/logout.jsp"%>
    <%--</sec:authorize>--%>
</body>
</html>
