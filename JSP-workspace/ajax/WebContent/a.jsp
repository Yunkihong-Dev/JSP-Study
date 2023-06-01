<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1></h1>
	<button id="send">눌러</button>
</body>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	$("#send").on("click", () => {
		$.ajax({
			url: "b.jsp",
			success: function(hello){
				$("h1").text(hello);
			}
		});
	})
</script>
</html>













