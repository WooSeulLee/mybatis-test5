<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="com.mybatis.test.vo.UserVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/views/user/user-insert">
<%
	List<UserVO> users = (List<UserVO>)request.getAttribute("users");
%>

<br>
<table border ="1">
	<tr>
	<th>번호</th>
	<th>아이디</th>
	<th>이름</th>
	</tr>
<%
for(UserVO user : users){
%>
	<tr>
	<td><%=user.getUiNum()%></td>
	<td><%=user.getUiId()%></td>
	<td><%=user.getUiName()%></td>
	</tr>
<%
}
%>
</table>
<button onclick = "localhost.href='window.views/user/user-insert'">유저 등록</button>

</form>
</body>
</html>