<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
    <c:param name="taskcontent">

        <h2>id : ${tasklist.taskid} のメッセージ詳細ページ</h2>

        <p>タイトル：<c:out value="${tasklist.tasktitle}" /></p>
        <p>メッセージ：<c:out value="${tasklist.taskcontent}" /></p>
        <p>作成日時：<fmt:formatDate value="${tasklist.taskcreated_at}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
        <p>更新日時：<fmt:formatDate value="${tasklist.taskupdated_at}" pattern="yyyy-MM-dd HH:mm:ss" /></p>

        <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>
        <p><a href="${pageContext.request.contextPath}/edit?id=${tasklist.taskid}">タスクを編集する</a></p>

    </c:param>
</c:import>
