<%@page import="com.mybatis.test.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	UserVO user = (UserVO)request.getAttribute("user");
%>

<form method = "GET" action ="/views/user/user-update">
<table border="1">
	<tr>
		<th>번호</th>
		<td><%=user.getUiNum()%></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><%=user.getUiName()%></td>
	</tr>
	<tr>
		<th>아이디</th>
		<td><%=user.getUiId()%></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><%=user.getUiPwd()%></td>
	</tr>
	<tr>
		<th>성별</th>
		<td><%=user.getUiGender()%></td>
	</tr>
	<tr>
		<th>생일</th>
		<td><%=user.getUiBirth()%></td>
	</tr>
	<tr>
		<th>취미</th>
		<td><%=user.getUiHobby()%></td>
	</tr>
	<tr>
		<th>소개</th>
		<td><%=user.getUiDesc()%></td>
	</tr>
	<tr>
		<th colspan="2">
		<button onclick="location.href='/user/user-update?uiName=<%=user.getUiNum()%>'">수정</button>
	</tr>
</table>

</form>
</body>
</html>