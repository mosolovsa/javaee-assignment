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
            <td>
                <button class="btn" type="submit" onclick="location.href='del_stores?id=${store.id}'">Delete</button>
                <button class="btn" type="submit" formmethod="post" onclick="location.href='add_stores?id=${store.id}'">Update</button>
            </td>
    </c:forEach>
    </tbody>
</table>
<button class="btn" type="submit" formmethod="get" onclick="location.href='add_stores'">Add new store</button>
</body>
</html>
