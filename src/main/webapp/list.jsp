<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./parts/header.html"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="main">
<jsp:include page="/parts/sideMenu.jsp"/>
<div class="content">
<table border="1">
	<thead>
		<tr>
			<th>学生番号</th>
			<th>学生名</th>
			<th>コース名</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="s" items="${list }">
			<tr>
				<td>${s.student_id }</td>
				<td>${s.student_name }</td>
				<td>${s.course_name }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/manegiment_console/index.jsp"><p>Topページへ</p></a>
</div>
</div>

<%@include file="./parts/footer.html"%>