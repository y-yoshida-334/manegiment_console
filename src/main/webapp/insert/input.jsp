<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./parts/header.html"%>

<div class="main">
<jsp:include page="/parts/sideMenu.jsp"/>
<div class="content">
<p>追加する学生の情報を入力してください。</p>
<p>
	<form action="/manegiment_console/function/StudentInsert" method="post">
		学生番号：<input type="text" name="student_id"><br>
		学生名　：<input type="text" name="student_name"><br>
	</form>
</div>
</div>

<%@include file="./parts/footer.html"%>