<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
<html>
<body>
<h2>Hello World!</h2>
<h2>${firstString}</h2>
<p><%=request.getAttribute("firstString")%></p>
</body>
</html>
