<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/29/2024
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<h2>Update Product</h2>
<form action="<%=request.getContextPath()%>/productController/update" method="post">
    <label for="id">Product Id</label>
    <input type="number" name="productId" id="id" value="${productUpdate.productId}" readonly><br>

    <label for="name">Product Name</label>
    <input type="text" name="productName" id="name" value="${productUpdate.productName}"><br>

    <label for="desc">Description</label>
    <input type="text" name="description" id="desc" value="${productUpdate.description}"><br>

    <label for="price">Price</label>
    <input type="number" name="price" id="price" value="${productUpdate.price}"><br>

    <label for="image">Image_URL</label>
    <input type="text" name="image_url" id="image" value="${productUpdate.image_url}"><br>

    <label for="create">Image_URL</label>
    <input type="text" name="created_at" id="create" value="${productUpdate.created_at}"><br>

    <select name="category.categoryId" id="type">
        <c:forEach items="${categoryList}" var="category">
            <option value="${category.categoryId}">${category.categoryName}</option>
        </c:forEach>
    </select><br>

    <label>Status</label>
    <input type="radio" name="status" id="active" value="true" ${productUpdate.status?"checked":""}><label for="active">Active</label>
    <input type="radio" name="status" id="inActive" value="false" ${productUpdate.status?"":"checked"}><label for="inActive">Inactive</label><br>
    <button>Update</button>
</form>
</body>
</html>
