<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>게시글 목록</title>
</head>
<body>
<h2>게시글 목록</h2>
<a href ="/board/write">글쓰기</a>
<a href ="/logout">로그아웃</a>
<table border="1" width="600px">
    <tr>
        <th>번호</th>
        <th>작성자</th>
        <th>닉네임</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성일</th>
        <th>조회수</th>
        <th>추천수</th>
    </tr>
    <c:forEach var="row" items="${list}">
        <tr>
            <td>${row.id}</td>
            <td>${row.writer_account}</td>
            <td>${row.nick_name}</td>
            <td><a href="/board/${row.id}">${row.title}</a></td>
            <td>${row.content}</td>
            <td>${row.updated_at}</td>
            <td>${row.view_count}</td>
            <td>${row.good}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>