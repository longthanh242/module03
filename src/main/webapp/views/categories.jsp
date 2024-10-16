<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/29/2024
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category Management</title>
</head>
<body>
<h2>Category Management</h2>
<a href="<%=request.getContextPath()%>/categoryController/initCreate">Create New Category</a>
<a href="<%=request.getContextPath()%>/index.jsp">Home</a>
<table border="1">
    <thead>
    <tr>
        <th>Category Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categoryList}" var="cat" varStatus="loop">
        <tr>
            <td>${cat.categoryId}</td>
            <td>${cat.categoryName}</td>
            <td>${cat.description}</td>
            <td>${cat.status?"Active":"Inactive"}</td>
            <td>
                <a href="<%=request.getContextPath()%>/categoryController/initUpdate?categoryId=${cat.categoryId}">Edit</a>
                <a href="<%=request.getContextPath()%>/categoryController/delete?categoryId=${cat.categoryId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
