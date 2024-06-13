$(()=>{
	$("#btn").click(function(){
		//pc가 숫자를 하나 선택
		var $rnd = Math.floor(Math.random()*10);
		var $game = 360 * $rnd; // 360 * pc가 선택한 숫자
		$("#box").css("background-color","blue");	// style css를 변경하는 형태
		$("#box").css("transform","rotate("+$game+"deg)");
		$("#box").css("transition","3s");
	});
});


// js
// document.getElementById("box").style.backgroundColor="red";