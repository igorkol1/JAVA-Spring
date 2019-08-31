<%--
  Created by IntelliJ IDEA.
  User: igorkolodziejczyk
  Date: 31/08/2019
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Products List</title>
</head>
<body>
<c:forEach items="${productsList}" var="product">
    <c:out value="${product.toString()}"></c:out>
    <a href="addtocart/${product.getUuid()}/1">Add to card</a>
    <br>
</c:forEach>
</body>
</html>
