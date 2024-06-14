$(()=>{
	
	$("#mb_check").click(function(){	// 회원가입 버튼 클릭시
		if($("#mid").val()==""){
			alert("아이디를 입력하세요");
		}else if($("#mpw").val()==""){
			alert("비밀번호를 입력하세요");
		}else if($("#mpw").val()==""){
			alert("비밀번호를 입력하세요.");
		}else if($("#mpw_ok").val()==""){
			alert("비밀번호를 재입력하세요.");
		}else if($("#mpw").val() != $("#mpw_ok").val()){
			alert("비밀번호를 다시 확인하세요.");
		}else if($("#mname").val() == ""){
			alert("이름을 입력하세요.");
		}else if($("#memail").val() == ""){
			alert("이메일을 입력하세요.");
		}else if($("#cellPhone").val() == ""){
			alert("휴대폰 번호를 입력하세요.");
		}else if($("#mtel").val() == ""){
			alert("전화번호를 입력하세요.");
		}else if($("#addr").val() == ""){
			alert("주소를 입력하세요.");
		}else{
			if($(".form_element input"))
			//action = member_ok.do
			$("form").attr("method","post");
			$("form").attr("action","./member_ok.do");
			$("form").submit();
		}
	});
	
	$("#mailcorp").change(function(){
		var $part = $(this).val();
		if($part=="self"){	// 직접 입력 시 초기화
			$("#memail").prop("value","");
		} else {
			// 사용자가 미입력시 선택할 경우
			var $usermail = $("#memail").val();
			if($usermail == ""){
				//$("#$usermail").val("@"+$part);
				$("#memail").prop("value","@"+$part);
				$("#memail").focus();
			} else {
					console.log($usermail.indexOf("@")); // 확인필요
				if($usermail.indexOf("@") <= 0){	//@가 없을 때 (-1)
					$("#memail").prop("value",$usermail + "@"+ $part);
				} else {
				//	$("#memail").prop("value","");
				//	$("#memail").prop("value","@"+$part);
				//	$("#memail").focus();
					$("#mailcorp").css("display","none");	// 최종적으로 메일이 확인이 되었을 경우 선택사항 보이지 않도록 설정
				}
			}
		}
	});
	
	
});