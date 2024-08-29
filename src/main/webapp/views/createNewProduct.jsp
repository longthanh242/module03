<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Create New Product</title>
</head>
<body>
    <h2>Create New Product</h2>
    <form:form modelAttribute="productDTO" action="/productController/create" method="post">
        <form:label path="productName">Product Name</form:label>
        <form:input path="productName"/>
        <form:errors path="productName"/><br>

        <form:label path="category.categoryId" for="category">Category Name</form:label>
        <form:select path="category.categoryId" id="category">
            <form:option value="0" label="-- Please Select --"/>
            <form:options items="${categoryList}" itemValue="categoryId" itemLabel="categoryName"/>
        </form:select><br>

        <form:label path="description">Description</form:label>
        <form:input path="description"/><br>

        <form:label path="price">Price</form:label>
        <form:input type="number" path="price"/>
        <form:errors path="price"/><br>

        <form:label path="image">Image</form:label>
        <form:input type="file" path="image"/>
        <form:errors path="image"/><br>

        <form:label path="created_at">Created At</form:label>
        <form:input type="date" path="created_at"/>
        <form:errors path="created_at"/><br>


        <form:button>Create</form:button>
    </form:form>
</body>
</html>
