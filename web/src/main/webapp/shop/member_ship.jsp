<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link type="text/css" rel="stylesheet" href="./common.css?v=1">
<link type="text/css" rel="stylesheet" href="./members.css?v=1">
<link type="text/css" rel="stylesheet" href="./reset.css?v=1">
<link type="text/css" rel="stylesheet" href="./chosen.css?v=1">
</head>
<script src="./jquery3.js"></script>
<script src="./member_ship.js?v=1"></script>
<body>
	<script>
$(()=>{
	$("#addr_btn").click(function(){
		sample2_execDaumPostcode();	// daum에서 제공한 함수명
	});
});
</script>
	<form id="frm">
		<input type="hidden" name="ag1"
			value="<%=request.getAttribute("ag1")%>"> <input
			type="hidden" name="ag2" value="<%=request.getAttribute("ag1")%>">
		<div class="base_info_box">
			<h3>기본정보</h3>
			<span class="important"></span>
			<div class="base_info_sec">
				<table border="0" cellpadding="0" cellspacing="0">
					<colgroup>
						<col width="25%">
						<col width="75%">
					</colgroup>
					<tbody>
						<tr>
							<th><span class="important">아이디</span></th>
							<td>
								<div class="member_warning">
									<input type="text" name="mid" id="mid">
								</div>
							</td>
						</tr>
						<tr class="">
							<th><span class="important">비밀번호</span></th>
							<td class="member_password">
								<div class="member_warning">
									<input type="password" id="mpw" name="mpw" autocomplete="off" placeholder="">
								</div>
							</td>
						</tr>
						<tr class="">
							<th><span class="important">비밀번호 확인</span></th>
							<td>
								<div class="member_warning">
									<input type="password" id="mpw_ok" class="check-id" autocomplete="off">
								</div>
							</td>
						</tr>
						<tr>
							<th><span class="important">이름</span></th>
							<td>
								<div class="member_warning">
									<input type="text" id="mname" name="mname" value="" maxlength="30">
								</div>
							</td>
						</tr>
						<tr>
							<th><span>이메일</span></th>
							<td class="member_email">
								<div class="member_warning">
									<input type="text" id="memail" name="memail" value="" tabindex="-1" style="float: left;">
									<select id="mailcorp" class="chosen-select" style="display: block;">
										<option value="self">직접입력</option>
										<option value="naver.com">naver.com</option>
										<option value="hanmail.net">hanmail.net</option>
										<option value="daum.net">daum.net</option>
										<option value="nate.com">nate.com</option>
										<option value="hotmail.com">hotmail.com</option>
										<option value="gmail.com">gmail.com</option>
									</select>
								</div>
								<div class="form_element">
									<label> <input type="checkbox" name="event_mail" value="Y">정보/이벤트 메일 수신에
										동의합니다.
									</label>
								</div>
							</td>
						</tr>
						<tr>
							<th><span>휴대폰번호</span></th>
							<td class="member_address">
								<div class="address_postcode">
									<input type="text" id="cellPhone" name="cellPhone" maxlength="11"
										placeholder="- 없이 입력하세요." value="">
								</div>
								<div class="form_element">
									<input type="checkbox" id="smsFl" name="event_sms" value="Y"> <label for="smsFl"
										class="check_s ">정보/이벤트 SMS 수신에 동의합니다.</label>
								</div>
							</td>
						</tr>
						<tr>
							<th><span>전화번호</span></th>
							<td>
								<div class="member_warning">
									<input type="text" id="mtel" name="mtel" maxlength="12" placeholder="- 없이 입력하세요."
										value="">
								</div>
							</td>
						</tr>
						<tr>
							<th><span>주소</span></th>
							<td class="member_address">
								<div id="layer"
									style="display: none; position: fixed; overflow: hidden; z-index: 1; -webkit-overflow-scrolling: touch;">
									<img src="//t1.daumcdn.net/postcode/resource/images/close.png"
										id="btnCloseLayer"
										style="cursor: pointer; position: absolute; right: -3px; top: -3px; z-index: 1"
										onclick="closeDaumPostcode()" alt="닫기 버튼">
								</div>
								<!-- 주소코드 -->
								<div class="address_postcode">
									<!-- 우편번호 5자리 -->
									<input type="text" name="addr_post" id="addr_post" readonly="readonly" style="width: 100px;"
										value="">
									<button type="button" id="addr_btn">우편번호검색</button>
								</div>
								<div class="address_input">
									<div class="member_warning">
										<!-- 도로명 주소 -->
										<input type="text" name="addr" id="addr" readonly="readonly" value="">
									</div>
									<div class="member_warning js_address_sub">
										<!-- 상세주소 -->
										<input type="text" name="addr2" id="addr2" value="">
									</div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<button type="button" id="mb_check">회원가입 완료</button>
			</div>
		</div>
	</form>
</body>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    // 우편번호 찾기 화면을 넣을 element
    var element_layer = document.getElementById('layer');

    function closeDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_layer.style.display = 'none';
    }

    function sample2_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('addr_post').value = data.zonecode;
                document.getElementById("addr").value = addr;

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_layer.style.display = 'none';
            },
            width : '100%',
            height : '100%',
            maxSuggestItems : 5
        }).embed(element_layer);

        // iframe을 넣은 element를 보이게 한다.
        element_layer.style.display = 'block';

        // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
        initLayerPosition();
    }

    // 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
    // resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
    // 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
    function initLayerPosition(){
        var width = 300; //우편번호서비스가 들어갈 element의 width
        var height = 400; //우편번호서비스가 들어갈 element의 height
        var borderWidth = 5; //샘플에서 사용하는 border의 두께

        // 위에서 선언한 값들을 실제 element에 넣는다.
        element_layer.style.width = width + 'px';
        element_layer.style.height = height + 'px';
        element_layer.style.border = borderWidth + 'px solid';
        // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
        element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
        element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
    }
</script>
</html>