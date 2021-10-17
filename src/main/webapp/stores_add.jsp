<%--
  Created by IntelliJ IDEA.
  User: cepera
  Date: 17.10.2021
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="form">
        <h2>Add/edit store</h2>
        <form action="add_stores" method="post">
            <input type="hidden" name="id" value=${store.id}>
            <div>
                <label for="name">Name</label>
                <input type="text" name="name" id="name" class="input input-store" placeholder = "Store name" value="${store.name}">
            </div>
            <div>
                <div class="buttongroup">
                    <button class="btn btn-form" type="submit">Confirm</button>
                    <button class="btn" onclick="location.href='stores'">Cancel</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
