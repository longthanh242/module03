<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>PRODUCT MANAGEMENT</h1>
<ul>
    <li><a href="<%=request.getContextPath()%>/categoryController/renderAll">Category Management</a></li>
    <li><a href="<%=request.getContextPath()%>/productController/renderAll">Product Management</a></li>
</ul>
</body>
</html>