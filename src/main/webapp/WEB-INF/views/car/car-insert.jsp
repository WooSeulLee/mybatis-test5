<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>차량 등록</h3>
<form method="POST" action="/car/car-insert">
	<input type="text" name = "ciName" placeholder="모델명">
	<input type="text" name = "ciYear" placeholder="년식">
	<button>등록</button>
	</form>
</body>
</html>