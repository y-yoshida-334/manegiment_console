<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- ヘッダー部分をインクルード -->
<%@ include file="/parts/header.html" %>

<!-- JSTLライブラリの読み込み -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="main">
    <!-- サイドメニューをインクルード -->
    <jsp:include page="/parts/sideMenu.jsp" />
    
    <div class="content">
        <!-- 学生情報の一覧を表示するテーブル -->
        <table border="1">
            <thead>
                <tr>
                    <th>学生番号</th>
                    <th>学生名</th>
                    <th>コース名</th>
                </tr>
            </thead>
            <tbody>
                <!-- JSTLのforEachを使って、リスト内の各学生情報を表示 -->
                <c:forEach var="s" items="${list}">
                    <tr>
                        <td>${s.student_id}</td>
                        <td>${s.student_name}</td>
                        <td>${s.course_name}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- トップページへのリンク -->
        <a href="/manegiment_console/index.jsp">
            <p>Topページへ</p>
        </a>
    </div>
</div>

<!-- フッター部分をインクルード -->
<%@ include file="/parts/footer.html" %>
