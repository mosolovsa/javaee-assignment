<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="form">
    <h2>Remove store from ${mall.name}</h2>
    <c:forEach items="${to_del}" var="store">
        <tr>
            <td> ${store.id}</td>
            <td> ${store.name}</td>
            <td>
                <form action="del_rels" method="post">
                    <input type="hidden" name="mall_id" value=${mall.id}>
                    <input type="hidden" name="store_id" value=${store.id}>
                    <button class="btn btn-form" type="submit">Confirm</button>
                </form>
            </td>
                <%--        <td><button class="btn" type="submit" formmethod="post" onclick="location.href='add_rels?mall_id=${mall.id}&store_id=${store.id}'">Add</button></td>--%>
        </tr>
    </c:forEach>
</div>
</body>
</html>
