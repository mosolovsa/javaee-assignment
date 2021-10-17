<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Malls</title>
</head>
<body>
    <table>
        <tr>
            <th>id</th><th>name</th><th>address</th><th>stores</th>
        </tr>
        <tbody>
        <c:forEach items="${malls}" var="mall">
            <tr><td> ${mall.id}</td>
                <td> ${mall.name}</td>
                <td> ${mall.address}</td>
                <td>
                    ${mall.stores.toArray()[0].name}
                    <c:forEach items="${mall.stores}" var="store" begin="1">, ${store.name}</c:forEach>
                </td>
                <td>
                    <button class="btn" type="submit" onclick="location.href='del_malls?id=${mall.id}'">Delete</button>
                    <button class="btn" type="submit" formmethod="post" onclick="location.href='add_malls?id=${mall.id}'">Update</button>
                </td>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
