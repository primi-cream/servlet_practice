$(()=>{
	$("#today").datepicker();
	
	$("#popup").draggable();	// 마우스, 핑거 해당 오브젝트의 위치를 변경
	$("#popup").droppable({		// 다른 오브젝트가 해당 오브젝트 안에 들어올 경우 작동하는 원리
		drop:function(){
			$(this).css("background-color","orange");		
		}
	});

	$("#popup2").draggable();
	$("#menu").selectable();	// 선택한 오브젝트를 표시하는 함수 (css와 함께 사용)
	$("#menu2").sortable();
});