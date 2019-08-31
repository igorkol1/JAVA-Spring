<%--
  Created by IntelliJ IDEA.
  User: igorkolodziejczyk
  Date: 31/08/2019
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${cartitems}" var="cartitem">
    ${cartitem}<br>
</c:forEach>
W koszyku jest ${numberOfProducts} pozycji.
W koszyku jest ${quantityOfProducts} produktów.
Wartość koszyka to: ${valueOdProducts}.
</body>
</html>
