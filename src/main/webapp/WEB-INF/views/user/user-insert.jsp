<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>유저 등록</h3>
<form method="POST" action=/user/user-insert>
<table border="1">
      <tr>
         <th>이름</th>
         <td><input type="text" name="uiName" id="uiName"></td>
      </tr>
      <tr>
         <th>아이디</th>
         <td><input type="text" name="uiId" id="uiId"></td>
      </tr>
      <tr>
         <th>비밀번호</th>
         <td><input type="password" name="uiPwd" id="uiPwd"></td>
      </tr>
      <tr>
         <th>성별</th>
         <td>
            <label for="male">남</label>
            <input type="radio" name="uiGender" id="male" value="1">
            <label for="female">여</label>
            <input type="radio" name="uiGender" id="female" value="2">
         </td>
      </tr>
      <tr>
         <th>생년월일</th>
         <td><input type="date" name="uiBirth" ></td>
      </tr>
      <tr>
         <th>취미</th>
         <td>
            <label for="snowboard">스노우보드</label>
            <input type="checkbox" name="uiHobby" id="snowboard" value="스노우보드"><br>
            <label for="pool">포켓볼</label>
            <input type="checkbox" name="uiHobby" id="pool" value="포켓볼"><br>
            <label for="movie">영화</label>
            <input type="checkbox" name="uiHobby" id="movie" value="영화"><br>
            <label for="drive">드라이브</label>
            <input type="checkbox" name="uiHobby" id="drive" value="드라이브"><br>
         </td>
      </tr>
      <tr>
         <th>자기소개</th>
         <td><textarea name="uiDesc" rows="10" cols="80" id="uiDesc"></textarea></td>
      </tr>
      <tr>
      	<th colspan="2" rowspan="5"><button>유저등록</button></th>
      </tr>
   </table>
</form>
</body>
</html>