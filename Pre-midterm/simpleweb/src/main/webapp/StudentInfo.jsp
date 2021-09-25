<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25/9/2564
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Info</title>
</head>
<body>
    <h2>New Student has been save</h2>
    Student id: ${student.id}<br>
    Student name: ${student.name}<br>
    Gpax: ${student.gpax}
    <hr>
    <a href="index.jsp"><button> OK </button></a><br>
    request.param.id: ${param.id}<br>
    request.param.name: ${param.name}<br>
    request.param.gpax: ${param.gpax}
</body>
</html>
