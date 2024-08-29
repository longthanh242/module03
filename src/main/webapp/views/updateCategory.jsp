<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/29/2024
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Category</title>
</head>
<body>
<h2>Update Category</h2>
<form action="<%=request.getContextPath()%>/categoryController/update" method="post">
    <label for="id">Category Id</label>
    <input type="number" name="categoryId" id="id" value="${categoryUpdate.categoryId}" readonly><br>
    <label for="name">Category Name</label>
    <input type="text" name="categoryName" id="name" value="${categoryUpdate.categoryName}"><br>
    <label for="desc">Description</label>
    <input type="text" name="description" id="desc" value="${categoryUpdate.description}"><br>
    <label>Status</label>
    <input type="radio" name="status" id="active" value="true" ${categoryUpdate.status?"checked":""}><label for="active">Active</label>
    <input type="radio" name="status" id="inActive" value="false" ${categoryUpdate.status?"":"checked"}><label for="inActive">Inactive</label><br>
    <button>Update</button>
</form>
</body>
</html>
