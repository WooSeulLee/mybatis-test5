<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<form method="POST" action="/car/car-insert">
	<table border="1">
		
		<tr>
			<th>모델명</th>
			<td><input type="text" name="ciName"></td>
		</tr>
		<tr>
			<th>년식</th>
			<td><input type="text" name="ciYear"></td>
		</tr>
		<tr>
			<th colspan="2">
				<button>등록</button>
			</th>
		</tr>
	</table>
</form>

<br>
<button onclick="location.href='/car/car-list'">목록보기</button>
</body>
</html>