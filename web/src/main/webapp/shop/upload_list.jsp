<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// do에서 만들어진 배열을 받아서 출력하게 됩니다.
ArrayList<Object> list = (ArrayList)request.getAttribute("list");    // do에서 사용한 동일한 배열 자료형을 생성하고, do에서 보낸 attribute를 받음
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

리뷰내용 : <%=list.get(2) %> <br>
상품이미지 : <img src="../<%=list.get(1) %>" width=550 height=550><br>
등록일 : <%=list.get(3) %><br>
</body>
</html>