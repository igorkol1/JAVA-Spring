<%--
  Created by IntelliJ IDEA.
  User: igorkolodziejczyk
  Date: 01/09/2019
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Workers</title>
</head>
<body>
All workers:<br>
<c:forEach items="${workers}" var="worker">
    ${worker}<br>
</c:forEach>

Random worker:
<c:out value="${randomWorker}"></c:out>

</body>
</html>
