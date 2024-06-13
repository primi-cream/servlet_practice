var data = ["500포인트","5000포인트","꽝","3000포인트","2000포인트","1000포인트"];
var count = 3;
$(()=>{
	var arr = new Array();	// 빈 배열(back-end에게 결과값 전달 용도)
	var $width = $(window).width();	// 브라우저의 가로크기
	var $height = $("#roule_bk > img").height();	// 배경사이즈
	$("#outline").css("height",$height+"px");	// 룰렛 게임 판 위치를 설정하기 위함

	var $random = 0;	// pc값 전역변수
	var $rd = 0;	// Object 최초 위치값
	
	// 게임 start 버튼 핸들링
	$("#gamebtn").click(function(){
		if(count==0){
			$("#result").val(arr);	// hidden값에 배열 결과값을 적용
			alert("해당 룰렛게임 총 3회만 진행가능합니다.");	
		} else {
		var $node = 0;	// 당첨결과
		$random = Math.ceil(Math.random()*360);	// 룰렛에 당첨에 대한 범위 설정
		if($random >= 100){
			$random = 150;
		}
		// 당첨에 대한 범위 설정
		// 1~59 : 500
		// 61~119 : 5000
		// 121~179 : 꽝
		// 181~239 : 3000
		// 241~299 : 2000
		// 301~359 : 1000
		
		if($random >= 1 && $random <= 59){ // 500
			$node = 0;
		} else if($random >= 61 && $random <= 119){ // 5000
			$node = 1;
		} else if($random >= 121 && $random <= 179){ // 꽝
			$node = 2;
		} else if($random >= 181 && $random <= 239){ // 3000
			$node = 3;
		} else if($random >= 241 && $random <= 299){ // 2000
			$node = 4;
		} else if($random >= 301 && $random <= 359){ // 1000
			$node = 5;
		} else { // 꽝
			$node = 2;
			$random = 167;	// pc가 선택한 값을 무시하고 직접 개발자가 수치값을 선택함
		};
		
		var $game = $random + $.fn.random();	// 랜덤으로 적용된 값을 return 받아서 처리
		
		$("#gameboard").css("transform","rotate("+$game+"deg)");
		// transition을 사용하지 않는 이유는 css(mroule.css)에 이미 적용되어 있음
		//consle.log(data[$node]);
		arr.push(data[$node]);	// 배열에 결과값을 삽입
		console.log(arr);
		}
		count--;
	});
	// 룰렛 회전판을 누적시켜서 수치값을 계산하는 return 함수
	$.fn.random = function(){	// $.fn : 확장형 함수 (fn : function 줄임말)
		$rd = $rd + 1800; // 5바퀴 후 결과를 출력하기 위함
		return $rd;
	}
	
	
	// 이벤트 완료 후 back-end에게 전달
	$("#btn").click(function(){
		$("#frm").attr("method","POST");
		$("#frm").attr("action","./gameok.do");
		$("#frm").submit();
	});
});

// js & es
//document.getElementById("frm").method = "POST";
//document.getElementById("frm").action = "./gameok.do";
//document.getElementById("frm").submit();




//es 7
/*
querySelector
var w = window.body.offsetWidth;
*/
//js
var w = window.innerWidth;	// 브라우저 화면의 가로사이즈
var w2 = window.outerWidth;	// 브라우저 전체화면 사이즈
var w3 = document.body.offsetWidth;	// es5 = jqeruy 동일한 사이즈
