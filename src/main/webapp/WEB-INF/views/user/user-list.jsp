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
<form action="/user">
<%
	List<UserVO> users = (List<UserVO>)request.getAttribute("users");
%>
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
<br>
<input type="text" name="uiNum" placeholder="유저 번호"><br>
<input type="text" name="uiId" placeholder="유저 아이디"><br>
<input type="text" name="uiName" placeholder="유저 이름"><br>
<button>검색</button><br><br>


</form>
</body>
</html>