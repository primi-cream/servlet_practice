<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//java에서 원시배열로 script 전송에 대한 값을 출력하지 못함
	String userlist[] = {"강호동","신동엽","유재석","김나래"};
	String userdata = ""; // 빈배열 (front-end 전달 변수)
	// 원시배열을 front-end 배열에 맞게 변환
	for(int w=0; w < userlist.length; w++){
		if(w==0){
			userdata = "'" + userlist[w] + "'";
		} else {
			userdata += ",'" + userlist[w] + "'";
		}
	}
	
	ArrayList<String> al = new ArrayList<String>();	
	al.add("신동엽");
	al.add("유관순");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jquery를 이용한 배열출력 (BackData 포함)</title>
<script src="./jquery.js"></script>
</head>
<script>
var data = [<%=userdata%>]; // backend 데이터를 js 변수 이관
var arr = new Array();	// JS 빈배열
//var data2 = JSON.stringify('{"user":"강호동","user2":"신동엽"}');
//var data3 = JSON.parse(data2);
<%
	int ww = 0;
	while(ww < al.size()){
%>
	arr.push('<%=al.get(ww)%>');	// 클래스 배열 -> JS 빈배열로 값을 이관
<%
		ww++;
	}
%>
console.log(arr);
$(()=>{
	$("#btn2").click(function(){
		var $ea = arr.length;
		var $w = 0;
		while($w < $ea){
			$("#list").append("<li>" + arr[$w] + "</li>");
			$w++;
		}
	});
	
	// Array.isArray : 데이터가 배열인지 아닌지 확인 (true, false)
	// Array.from : 문자(char)를 배열로 변환
	// $.parseJSON(data) 
	$("#btn").click(function(){
	//	var $data = JSON.stringify(data2);
	//	var $data = JSON.parse(data);	
	//	console.log($data);
		var $ea = data.length;
		var $w = 0;
		while($w < $ea){
			$("#list").append("<li>" + data[$w] + "</li>");
			$w++;
		}
	});
});
</script>
<body>
<ul id="list">

</ul>
<input type="button" value="유저리스트(원시배열)" id="btn">
<input type="button" value="유저리스트(클래스배열)" id="btn2">
</body>
</html>