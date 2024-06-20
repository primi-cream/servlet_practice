$(()=>{
	$("#box").swipeleft(function(){	// 오른쪽 -> 왼쪽
		$(this).css("background-color","skyblue");
	});
	
	$("#box").swiperight(function(){	// 왼쪽 -> 오른쪽
		$(this).css("background-color","black");
	});
	
	$("#box2").swipe(function(){	// 양방향 모두 사용가능
		$(this).css("background-color","blue");
	});
	
	$("#box3").taphold(function(){	// 지속적으로 오브젝트를 누를경우 (ex.지문인식)
		$(this).css("background-color","purple");
	});
	
	$("#box4").tap(function(){	// tap = click
		$(this).css("background-color","red");
	});
});
