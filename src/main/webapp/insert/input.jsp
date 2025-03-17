<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/parts/header.html"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="main">
<jsp:include page="/parts/sideMenu.jsp"/>
<div class="content">
<p>追加する学生の情報を入力してください。</p>
<p>
	<form action="/manegiment_console/function/insert/execute" method="post">
		学生番号：<input type="text" name="student_id"><br>
		学生名　：<input type="text" name="student_name"><br>
		コース名：<select name="student_course">
			<c:forEach var="item" items="${list }">
				<option value=${item.course_id }>${item.course_name }</option>
			</c:forEach>
		</select><br>
		<input type="submit" value="送信">
	</form>
</p>
</div>
</div>

<%@include file="/parts/footer.html"%>