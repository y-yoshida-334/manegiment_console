<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/parts/header.html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="main">
<jsp:include page="/parts/sideMenu.jsp"/>
<div class="content">
<p>データを更新する学生を選んでください</p>
<p>
	<form action="/manegiment_console/function/update/input" method="post">
            <select name="student_id" id="student_id">
                <c:forEach var="s" items="${list}">
                    <option value="<c:out value='${s.student_id}' />">
                        <c:out value="${s.student_name}" />
                    </option>
                </c:forEach>
            </select>
            <input type="submit" value="送信">
	</form>
</div>
</div>

<%@include file="/parts/footer.html"%>