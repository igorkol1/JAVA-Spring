<%--
  Created by IntelliJ IDEA.
  User: igorkolodziejczyk
  Date: 31/08/2019
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Multiply</title>
</head>
<body>

<table border="1">
    <c:forEach begin="1" end="${row}" var="currentRow">
        <tr>
            <c:forEach begin="1" end="${column}" var="currentColumn">
                <td>${currentRow*currentColumn}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

</body>
</html>
