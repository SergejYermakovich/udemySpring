<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>My page !!!</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
</head>
<body>

<form:form action="processStudentForm" modelAttribute="student" >
    <form:input path="firstName" type="text" placeholder="What s your firstName?"/>
    <form:input path="lastName" type="text" placeholder="What s your lastName?"/>
    <input type="submit" value="Submit query"/>
</form:form>

</body>
</html>
