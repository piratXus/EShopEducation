<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.09.2016
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
<html>
<body>
<h2>Hello World!</h2>
<h2>${firstString}</h2>
<p><%=request.getAttribute("firstString")%></p>
<c:forEach items="${mapper}" var="map">
    <p>${map.key} - ${map.value}</p>
</c:forEach>
<a href="/basket">Basket</a>
</body>
</html>
