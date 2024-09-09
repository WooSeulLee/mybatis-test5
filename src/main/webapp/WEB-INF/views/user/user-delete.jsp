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
<form method="POST" action="/user/user-delete">
<input type="hidden" id="uiNum" name="uiNum" value="<%=user.getUiNum()%>">
<table border ="1">
	<tr>
	<th>번호</th>
	<td><%=user.getUiNum()%></td>
	</tr>
	
	<tr>
	<th>아이디</th>
	<td><%=user.getUiId()%></td>
	</tr>
	
	<tr>
	<th>이름</th>
	<td><%=user.getUiName()%></td>
	</tr>
	
	<tr>
	<th>
	<button>삭제ㄴ</button>
	</th>
	</tr>

</table>
</form>
</body>
</html>