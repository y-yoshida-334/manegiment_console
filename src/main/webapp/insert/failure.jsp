<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/parts/header.html" %> <!-- ヘッダー部分のインクルード -->

<div class="main">
    <jsp:include page="/parts/sideMenu.jsp" /> <!-- サイドメニューのインクルード -->
    
    <div class="content">
        <!-- 登録失敗メッセージの表示 -->
        <p>登録に失敗しました。</p>
        
        <!-- トップページへのリンク -->
        <a href="/manegiment_console/index.jsp"><p>Topページへ</p></a>
    </div>
</div>

<%@ include file="/parts/footer.html" %> <!-- フッター部分のインクルード -->
