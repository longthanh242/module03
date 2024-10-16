<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/29/2024
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Management</title>
</head>
<body>
<h2>PRODUCT MANAGEMENT</h2>
<a href="<%=request.getContextPath()%>/productController/initCreate">Create New Product</a>
<a href="<%=request.getContextPath()%>/index.jsp">Home</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>IMAGE</th>
        <th>DESCRIPTION</th>
        <th>PRICE</th>
        <th>CATEGORY NAME</th>
        <th>CREATED</th>
        <th>STATUS</th>
        <th>ACTION</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productList}" var="product" varStatus="loop">
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td><img src="${product.image_url}" alt="${product.productName}" width="50px" height="50px"></td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.catName}</td>
            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${product.created_at}"/></td>
            <td>${product.status?"Active":"Inactive"}</td>
            <td>
                <a href="<%=request.getContextPath()%>/productController/initUpdate?productId=${product.productId}">Edit</a>
                <a href="<%=request.getContextPath()%>/productController/delete?productId=${product.productId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
