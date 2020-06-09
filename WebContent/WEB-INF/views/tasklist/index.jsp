<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="taskcontent">
        <h2>タスク一覧</h2>
        <ul>
            <c:forEach var="tasklist" items="${tasklists}">
                <li>
                    <a href="${pageContext.request.contextPath}/show?id=${tasklist.taskid}">
                        <c:out value="${tasklist.taskid}" />
                    </a>
                    ：<c:out value="${tasklist.tasktitle}"></c:out> &gt; <c:out value="${tasklist.taskcontent}" />
                </li>
            </c:forEach>
        </ul>

        <p><a href="${pageContext.request.contextPath}/new">新しいタスクの投稿</a></p>

    </c:param>
</c:import>