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
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>Basket</title>
    <link href="${pageContext.request.contextPath}/resources/css/general.css" rel="stylesheet" >
</head>
<body>
  <h1>Menu vertical</h1>
    <sec:authorize access="isAuthenticated()">
        <%@ include file="logout.jsp"%>
    </sec:authorize>
  <c:if test="${!(goodsInBasket.isEmpty())}">
    <c:forEach items="${goodsInBasket}" var="basket">
      <form action="/basket/deletebasket" method="post">
          <div>
              <h4>${basket.getName_seller()}</h4>
              <h4>${basket.getName_goods()}</h4>
              <h4>${basket.getPrice_things()}</h4>
              <h4>${basket.getCount_things()}</h4>
              <input type="hidden" value="${basket.getId()}" name="key"/>
              <button type="submit" value="Delete" style="display: inline-block">Delete</button>
          </div>
      </form>
    </c:forEach>
  </c:if>

<c:if test="${goodsInBasket.isEmpty()}">
    <h2>У вас нет товаров в корзине.</h2>
</c:if>
</body>
</html>
