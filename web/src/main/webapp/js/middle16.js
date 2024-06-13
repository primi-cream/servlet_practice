var faq = [
	["Q. [결제오류] 삼성카드 오류발생!!","Q.test1","Q.test2","Q,test3"],
	["A. 삼성카드는 APP에서 QR로 인증을 완료 하신 고객님에 한해서만 결제가 진행 됩니다.",
	"A.test1",
	"A.test2",
	"A.test3"]
];

$(()=>{
	var $w = 0;
	do{
		var $htmlcode ='<li><div class="q"><span class="s1">'+faq[0][$w]+'</span></div><div class="a">'+faq[1][$w]+
		'</div></li>';
	$("#ulcss").append($htmlcode);
		$w++;
	}while($w < faq[0].length);
	
	// Q를 클릭시 A가 출력되는 이벤트 핸들링 (node 사용시 무조건 같은 숫자 X)
	$("#ulcss > li").click(function(){
		var $node = $(this).index();
	//	console.log($node);
	// slideDown(슬라이드가 아래로 내려오면서 보여지는 형태)
	// slideUp(슬라이드 아래에서 위로 숨겨지는 형태)
	// slideToggle = slideDown + slideUp
		$("#ulcss > li:eq("+$node+") > .a").slideToggle();
	});
});