<%@page import="com.mybatis.test.vo.CarVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/car/car-list" >
	<label for="num">번호 : </label> <input type="text" id="num" name="ciNum" placeholder="번호 입력"><br>
	<label for="name">이름 : </label> <input type="text" id="name" name="ciName" placeholder="자종 입력"><br>
	<label for="year">연식 : </label> <input type="text" id="year" name="ciYear" placeholder="연식 입력"><br>
	<button>검색</button>
	<br><br>
</form>



<table border="1">
	<tr>
		<th>번호</th>
		<th>모델명</th>
		<th>년식</th>
	</tr>
<%
List<CarVO> cars = (List<CarVO>)request.getAttribute("cars");
for (CarVO car : cars){
%>
	<tr>
		<td><%=car.getCiNum()%></td>
		<td><a href='/car/car-view?ciNum=<%=car.getCiNum()%>'><%=car.getCiName()%></a></td>
		<td><%=car.getCiYear()%></td>
	</tr>
	
<% } %>
</table>
<br>
<button onclick="location.href='/views/car/car-insert'">차량 등록</button>

<a href='/'>홈으로가기</a>
</body>
</html>