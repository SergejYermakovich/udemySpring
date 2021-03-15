<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>My page !!!</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <style>
        .error {
            color:red;
        }
    </style>
</head>
<body>

<form:form action="processStudentForm" modelAttribute="student">
    <br><br>
    <form:input path="firstName"   placeholder="What s your firstName?"/>
    <br><br>
    <form:input path="lastName"   placeholder="What s your lastName?"/>
    <br><br>
    <form:select path="country">
        <form:options items="${countryOptions}"/>
    </form:select>
    <br><br>
    <form:radiobuttons items="${favouriteLanguages}" path="favouriteLanguage"/>
    <br><br>
    Operating systems:
    Linux<form:checkbox path="operatingSystems" value="Linux"/>
    Windows<form:checkbox path="operatingSystems" value="Windows"/>
    MacOS<form:checkbox path="operatingSystems" value="MacOS"/>
    <br><br>
    <input type="submit" value="Submit query"/>
</form:form>

</body>
</html>
