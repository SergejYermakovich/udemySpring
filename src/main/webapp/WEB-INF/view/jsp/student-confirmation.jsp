<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
The student is confirmed: ${student.firstName} ${student.lastName}
<br>
Country: ${student.country}
<br>
Lang: ${student.favouriteLanguage}
<br>
Operating systems:
<ul>
    <c:forEach var="system" items="${student.operatingSystems}">
        <li>${system}</li>
    </c:forEach>
</ul>
</body>
</html>
