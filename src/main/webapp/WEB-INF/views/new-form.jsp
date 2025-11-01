<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
<!-- 상대경로 사용, [현재 URL이 속한 계층의 상위 경로 + /save]
     ex) /servlet-mvc/members/new-form이 현재 경로면 save가 new-form을 대체함 -->
<form action="save" method="post">
username: <input type="text" name="username" />
age: <input type="text" name="age" />
<button type="submit">전송</button>
</form>
</body>
</html>