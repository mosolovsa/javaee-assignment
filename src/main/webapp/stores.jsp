<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stores</title>
</head>
<body>
<table>
    <tr>
        <th>id</th><th>name</th>
    </tr>
    <tbody>
    <c:forEach items="${stores}" var="store">
        <tr>
            <td>${store.id}</td>
            <td>${store.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
