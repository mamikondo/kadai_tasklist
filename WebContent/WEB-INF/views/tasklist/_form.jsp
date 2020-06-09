<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<label for="title">タスクの題名</label><br />
<input type="text" name="tasktitle" value="${tasklist.tasktitle}" />
<br /><br />

<label for="content">タスク内容</label><br />
<input type="text" name="taskcontent" value="${tasklist.taskcontent}" />
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録する</button>