<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.10.2016
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/pages/libheader.jsp" %>
<html>
<head>
    <title>Edit form goods</title>
</head>
<body>
    <form name = "goodsOne" id="select-form">
        <input type="hidden" value="${goods.getId()}"/>
        <select id="select-in-form">
            <c:forEach items="${listCompany}" var="company">
                <option value="${company.getId()}">${company.getName()}</option>
            </c:forEach>
        </select>
        <input type="text" value="${goods.getId_company()}" name="description"/>
        <input type="text" value="${goods.getTitle()}" name="title"/>
    </form>
</body>
</html>
