<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/parts/header.html"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="main">
<jsp:include page="/parts/sideMenu.jsp"/>
<div class="content">
<p>
	<form action="/manegiment_console/function/update/execute" method="post">
		<input type="hidden" name="student_id" value="${s.student_id }">
		お名前　：<input type="text" name="student_name" value="${s.student_name }"><br>
		コース名：<select name="student_course">
			<c:forEach var="item" items="${list }">
				<option value=${item.course_id } ${item.course_id eq s.student_course ? "seleced" : "" }>${item.course_name }</option>
			</c:forEach>
		</select><br>
		<input type="submit" value="送信">
	</form>
</p>
</div>
</div>

<%@include file="/parts/footer.html"%>