<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/parts/header.html"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- メインコンテンツ -->
<div class="main">

    <!-- サイドメニューを挿入 -->
    <jsp:include page="/parts/sideMenu.jsp"/>

    <div class="content">
        <!-- フォームの説明 -->
        <p>追加する学生の情報を入力してください。</p>

        <!-- 学生情報の入力フォーム -->
        <form action="/manegiment_console/function/insert/execute" method="post">
            <p>
                学生番号：<input type="text" name="student_id"><br>
                学生名　：<input type="text" name="student_name"><br>

                <!-- コース選択 -->
                コース名：
                <select name="student_course">
                    <c:forEach var="item" items="${list}">
                        <option value="${item.course_id}">${item.course_name}</option>
                    </c:forEach>
                </select><br>

                <!-- 送信ボタン -->
                <input type="submit" value="送信">
            </p>
        </form>
    </div>

</div>

<!-- フッターを挿入 -->
<%@include file="/parts/footer.html"%>
