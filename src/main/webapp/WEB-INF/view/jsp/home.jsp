<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>My page</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
</head>
<body>
<img src="${pageContext.request.contextPath}/resources/images/spring.png"/>
<p>Hello!!!!</p>
<br>
<br>
<a href="showForm">Hello world form</a>
<br>
<br>
<a href="student/showForm">student -> showForm</a>
<br>
<br>
<a href="customer/showForm">customer -> showForm</a>
</body>
</html>
