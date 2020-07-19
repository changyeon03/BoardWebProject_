<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-07-18
  Time: 오전 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시물 작성</title>
</head>
<body>
    <form action="/board", method="post">
        <label>작성자 :</label>
        <input name="writer_account" type="email"><br>
        <label>닉네임 :</label>
        <input name="nick_name" type="text"><br>
        <label>제목 :</label>
        <input name="title" type="text"><br>
        <label>내용 :</label>
        <input name="content" type="text" style="width:200px; height:50px;"><br>

        <input type="submit" value="작성">
    </form>
</body>
</html>
