<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>목록</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/images/favicon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/board/board.css">
</head>
<body>
    <main id="board">
    	<jsp:include page="../fix/header.jsp"/>
        <section id="board-banner">
            <div><a href="javascript:location.href='${pageContext.request.contextPath}/write.board'"><img src="${pageContext.request.contextPath}/static/images/board_banner.png"></a></div>
        </section>
        <section id="info-wrap">
            <article id="info-container">
                <h6 class="info">게시글 목록<br>${total}개</h6>
                <section class="order">
                    <a class="${sort == null or sort == 'recent' ? 'selected' : ''}">최신순</a>
                    <a class="${sort == 'popular' ? 'selected' : ''}">인기순</a>
                </section>
            </article>
            <section id="content-wrap">
                <ul>
                </ul>
                <div id="paging-wrap">
                	<c:if test="${prev}">
	                	<a href="${startPage - 1}" class="paging paging-move change-page"><img src="/static/images/prev.png" width="15px"></a>
                	</c:if>
                	<c:forEach var="i" begin="${startPage}" end="${endPage}">
                		<c:choose>
                			<c:when test="${i eq page}">
			                	<a href="javascript:void(0)" class="paging paging-checked"><c:out value="${i}"/></a>
                			</c:when>
                			<c:otherwise>
			                    <a href="${i}" class="paging change-page"><c:out value="${i}"/></a>
                			</c:otherwise>
                		</c:choose>
                	</c:forEach>
                	<c:if test="${next}">
	                    <a href="${endPage + 1}" class="paging paging-move change-page"><img src="/static/images/next.png" width="15px"></a>
                	</c:if>
                </div>
            </section>
        </section>
    </main>
    <form action="${pageContext.request.contextPath}/listOk.board" name="page-form">
    	<input type="hidden" name="page" value="${page}">
    	<input type="hidden" name="sort" value="${sort}">
    	<input type="hidden" name="type" value="${type}">
    	<input type="hidden" name="keyword" value="${keyword}">
    </form>
</body>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/board/board.js"></script>
<script>
	let boards = `${boards}`;
	let contextPath = `${pageContext.request.contextPath}`;
	let $form = $("form[name='page-form']");
	$("a.change-page").on("click", function(e){
		e.preventDefault();
		$form.find("input[name='page']").val($(this).attr("href"));
		$form.submit();
	});
	
	
	
	
	
</script>
<script src="${pageContext.request.contextPath}/static/js/board/list.js"></script>
</html>
















