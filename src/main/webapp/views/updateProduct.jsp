<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form action="<%=request.getContextPath()%>/productController/update" method="post" enctype="multipart/form-data">
    <label for="id">Product Id</label>
    <input type="number" name="productId" id="id" value="${productUpdate.productId}" readonly><br>

    <label for="name">Product Name</label>
    <input type="text" name="productName" id="name" value="${productUpdate.productName}"><br>

    <label for="desc">Description</label>
    <textarea name="description" id="desc">${productUpdate.description}</textarea> <br>

    <label for="price">Price</label>
    <input type="number" name="price" id="price" value="${productUpdate.price}"><br>

    <label for="image">Image</label>
    <img src="/uploads" alt="">
    <input type="file" name="image" id="image" value="${productUpdate.image_url}"><br>

    <label for="create">Created At</label>
    <input type="date" name="created_at" id="create" value="${productUpdate.created_at}"><br>

    <label for="category">Category Name</label>
    <select name="category.categoryId" id="category">
        <c:forEach items="${categoryList}" var="category">
            <option value="${category.categoryId}" ${category.categoryId == productUpdate.category.categoryId?"selected":""}>${category.categoryName}</option>
        </c:forEach>
    </select><br>
    <label>Status</label>
    <input type="radio" name="status" id="active" value="true" ${productUpdate.status?"checked":""}><label for="active">Active</label>
    <input type="radio" name="status" id="inActive" value="false" ${productUpdate.status?"":"checked"}><label
        for="inActive">Inactive</label><br>
    <button>Update</button>
</form>
<%--<form:form modelAttribute="productUpdate" method="post" action="/productController/update" enctype="multipart/form-data">--%>
<%--    <form:label path="productId">BookID</form:label>--%>
<%--    <form:input path="productId" readonly="true"/>--%>
<%--    <form:errors path="productId"/><br>--%>

<%--    <form:label path="productName">Book Name</form:label>--%>
<%--    <form:input path="productName"/>--%>
<%--    <form:errors path="productName"/><br>--%>

<%--    <form:label path="category.categoryId">Type Name</form:label>--%>
<%--    <form:select path="category.categoryId">--%>
<%--        &lt;%&ndash;    Dùng cách nào cũng được    &ndash;%&gt;--%>
<%--        &lt;%&ndash;        <c:forEach items="${bookTypeList}" var="bookType">&ndash;%&gt;--%>
<%--        &lt;%&ndash;            <option value="${bookType.typeId}" ${bookType.typeId == book.bookType.typeId? "selected": ""}>${bookType.typeName}</option>&ndash;%&gt;--%>
<%--        &lt;%&ndash;        </c:forEach>&ndash;%&gt;--%>
<%--        <form:options items="${categoryList}" itemValue="categoryId" itemLabel="categoryName" />--%>
<%--    </form:select><br>--%>

<%--    <form:label path="description">Description</form:label>--%>
<%--    <form:input path="description"/>--%>
<%--    <form:errors path="description"/><br>--%>

<%--    <form:label path="price">Price</form:label>--%>
<%--    <form:input type="number" path="price"/>--%>
<%--    <form:errors path="price"/><br>--%>

<%--    <form:label path="image_url">Avatar</form:label>--%>
<%--    <form:input path="image_url" type="file"/><br>--%>

<%--    <form:label path="created_at">Created At</form:label>--%>
<%--    <form:input path="created_at" type="date"/>--%>
<%--    <form:errors path="created_at"/><br>--%>

<%--    <form:label path="status">Status</form:label>--%>
<%--    <form:radiobutton path="status" label="Active" value="true"/>--%>
<%--    <form:radiobutton path="status" label="Inactive" value="false"/><br>--%>

<%--    <form:button>UPDATE</form:button>--%>
<%--</form:form>--%>
</body>
</html>
