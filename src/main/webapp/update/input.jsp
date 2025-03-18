<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/parts/header.html"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="main">
<jsp:include page="/parts/sideMenu.jsp"/>
<div class="content">
<c:forEach var="ss" items="${list_s }">
	<c:set var="student_course" value="${ss.student_course }"></c:set>
	<c:set var="student_name" value="${ss.student_name }"/>
	<c:set var="student_id" value="${ss.student_id }"/>
</c:forEach>

	<form action="/manegiment_console/function/update/execute" method="post">
		<input type="hidden" name="student_id" value="${student_id }">
		お名前　：<input type="text" name="student_name" value="${student_name }"><br>
		コース名：<select name="student_course">
			<c:forEach var="list" items="${list }">
				<option value="${list.course_id }" ${list.course_id eq student_course ? "selected" : "" }>${list.course_name }</option>
			</c:forEach>
		</select>
		<input type="submit" value="送信"> 
	</form>
</div>
</div>

<%@include file="/parts/footer.html"%>