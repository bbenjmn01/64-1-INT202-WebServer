<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
<%--    <style>--%>
<%--        .box {--%>
<%--            display: inline-flex;--%>
<%--            border: 1px solid gray;--%>
<%--            margin: 10px;--%>
<%--            padding: 5px;--%>
<%--            width: 30px;--%>
<%--            text-align: right;--%>
<%--            border-radius: 10%;--%>
<%--        }--%>
<%--    </style>--%>
</head>
<body>
<%--<div style="padding: 10px;display: block;width: 50%;margin: auto">--%>
<%--    <c:forEach begin="1" end="100" var="value">--%>
<%--        <div class="box">${value}</div>--%>
<%--    </c:forEach>--%>
<%--</div>--%>
    <div style="padding: 10px;display: block;width: 50%;margin: auto">
        <h3>Memu</h3>
        <a href="course-list">1) ลงทะเบียน</a><br>
        <a href="course-registered-history">2) ประวัติการลงทะเบียน</a>
    </div>
</body>
</html>