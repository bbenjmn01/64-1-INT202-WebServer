<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31/8/2564
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentInfo</title>
</head>
<body>
    <h2>New Student has been save</h2>
    Student id: ${requestScope.student.id} <br>
    Student name: ${student.name} <br>
    Gpax: ${student.gpax} <br>
    <hr>
    <a href="index.jsp"><button>OK</button></a>
    request.param.id: ${param.id} <br>
    request.param.name: ${param.name} <br>
    request.param.gpax: ${param.gpax} <br>
    Browser: ${header["User-Agent"]} <br>
    Accept-Language: ${headerValues["Accept-Language"][0]}, ${headerValues["Accept-Language"][1]}
</body>
</html>
