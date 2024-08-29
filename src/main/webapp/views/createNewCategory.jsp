<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/29/2024
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Category</title>
</head>
<body>
    <h2>Create New Category</h2>
    <form:form modelAttribute="categoryDTO" action="/categoryController/create" method="post">
        <form:label path="categoryName">Category Name</form:label>
        <form:input path="categoryName"/><br>
        <form:errors path="categoryName"/>
        <form:label path="description">Description</form:label>
        <form:input path="description"/><br>
        <form:button>Create</form:button>
    </form:form>
</body>
</html>
