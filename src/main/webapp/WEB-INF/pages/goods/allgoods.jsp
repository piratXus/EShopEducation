<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.10.2016
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/pages/libheader.jsp" %>
<html>
<head>
    <title>List goods</title>
</head>
<body>
    <c:if test="${msg.length() != 0}">
        <h1>${msg}</h1>
    </c:if>
    <div class="list-goods">
        <c:if test="${!(goodsList.isEmpty())}">
            <c:forEach items="${goodsList}" var="goods">
                <div class="item-goods">
                    <p>${goods.getName_company()}</p>
                    <p>${goods.getTitle()}</p>
                    <p>${goods.getDecription()}</p>
                    <p>${goods.getPrice()}</p>
                    <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPERADMIN')">
                        <a href="/editgoods/${goods.getId()}">Edit</a>
                    </sec:authorize>
                </div>
            </c:forEach>
        </c:if>
    </div>
</body>
</html>
