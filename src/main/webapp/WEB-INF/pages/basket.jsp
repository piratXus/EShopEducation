<%--
  Created by IntelliJ IDEA.
  User: raks
  Date: 20.09.16
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Basket</title>
</head>
<body>
  <h1>Menu vertical</h1>
  <% if ("${goodsInBasket}".length()!=0) {%>
  <c:forEach items="${goodsInBasket}" var="map">

      <form action="/basket" method="post">
          <div>
            <h4 style="display: inline-block">${map.getId_user()}</h4>
            <h4 style="display: inline-block">${map.getPrice_things()}</h4>
            <h4 style="display: inline-block">${map.getCount_things()}</h4> <h4>${map.getId_seller()}</h4>
          </div>
          <input type="hidden" value="${map.getId()}" name="key"/>
          <button type="submit" value="Delete">Delete</button>
      </form>

  </c:forEach>
<%} else {%>
    <h2>У вас нет товаров в корзине.</h2>
<% } %>
</body>
</html>
