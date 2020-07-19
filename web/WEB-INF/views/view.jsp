<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-07-18
  Time: 오후 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>게시물 보기</title>
</head>
<body>
    <c:forEach var="view" items="${view}">
        작성자 : ${view.writer_account} <br>
        닉네임 : ${view.nick_name} <br>
        작성일 : ${view.created_at} <br>
        제목 : ${view.title} <br>
        내용 : ${view.content} <br>
        조회수 : ${view.view_count} <br>
        추천수 : ${view.good} <br>
        <a href = "/board/modify/${view.id}">게시글 수정</a>
        <a href = "/board/delete/${view.id}">게시물 삭제</a>
    </c:forEach>

</body>
</html>