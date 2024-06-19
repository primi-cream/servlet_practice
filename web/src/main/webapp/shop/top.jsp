<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 문자열 변환 형태 : (String), String.valueOf(), toString() 그렇다면.. +""는?
	HttpSession hs = request.getSession();
	String id = (String)hs.getAttribute("id");
	String name = (String)hs.getAttribute("name");
//	if(id == null){  // if(name == null)
//		out.print("test"); // out.print web 출력
//	} else if(id.equals("null")){
//		out.print("test2");
//	} else {
//		out.print("test3");
//	}
	// toString() => null일 경우 Error
	// String.valueOf() => 자료형 자체를 문자형으로 변환하는 구조 (null 포함 단, "null")
	// (String) => Object형태의 배열구조에만 적용가능
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹 사이트 상단 페이지</title>
<script src="./jquery3.js"></script>
</head>
<body>
<%if(id == null || name == null){ %> <!-- 로그인 하지 않았을 경우 -->
<p><a href="./login.html">로그인</a> | 회원가입 | 고객센터</p> <!-- 로그인 전 메뉴 -->
<%} else { %>
<p><%=name %>님 환영합니다.<input type="button" value="로그아웃" id="btn"> | 장바구니 | 고객센터</p> <!-- 로그인 후 메뉴 -->
<!-- <p><%//out.print(name); %>님 환영합니다. | 장바구니 | 고객센터</p> <!-- 로그인 후 메뉴 -->
<%} %>
</body>
<script>
	$(()=>{
		$("#btn").click(function(){
			// confirm : 확인, 취소 사용자가 선택하는 경고메세지
			if(confirm("로그아웃 하시겠습니다.")){	// 확인
				location.href='./logout.do';
			};
			
		});
	});
</script>
</html>