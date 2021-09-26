<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14/9/2564
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course Register History</title>
    <link rel="stylesheet" type="text/css" href="assets/bootstrap-4.5/css/bootstrap.min.css"/>
</head>
<body>
<div class="container m-auto bg-light w-75">
    <div class="row w-100 h2">Courses Register History ::</div>
    <c:forEach items="${courseRegistered.history}" var="entry">
    <div class="row">Semester: ${entry.key}</div>
    <c:forEach items="${entry.value}" var="subject" varStatus="vs">
    <div class="row bg-transparent">
        <div class="col-1">${vs.count}</div>
        <div class="col-1">${subject.subjectId}</div>
        <div class="col-6">${subject.title}</div>
        <div class="col-1">${subject.credit}</div>
    </div>
    </c:forEach>
    <div>--------------------</div>
    </c:forEach>
    <p class="h2 text-danger">${message}</p>
    <div class="row"><a href="index.jsp">
        <button class="px-2 m-4"> OK</button>
    </a></div>
</body>
</body>
</html>
