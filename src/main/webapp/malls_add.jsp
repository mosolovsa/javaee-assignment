<%--
  Created by IntelliJ IDEA.
  User: cepera
  Date: 17.10.2021
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="form">
    <h2>Add/edit mall</h2>
    <form action="add_malls" method="post">
        <input type="hidden" name="id" value=${mall.id}>
        <div>
            <label for="name">Name</label>
            <input type="text" name="name" id="name" class="input input-store" placeholder = "Mall name" value="${store.name}">
        </div>
        <div>
            <label for="name">Address</label>
            <input type="text" name="address" id="address" class="input input-store" placeholder = "Mall address" value="${store.address}">
        </div>
        <div>
            <div class="buttongroup">
                <button class="btn btn-form" type="submit">Confirm</button>
                <button class="btn" onclick="location.href='malls'">Cancel</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
