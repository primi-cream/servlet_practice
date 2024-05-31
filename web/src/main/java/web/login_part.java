package web;
// Module : login
public class login_part {
	
	private String result = "";
	
	public String person(String id, String pw) {	// 일반회원
		if(id == "apink" && pw == "0486") {
			this.result = "로그인 하셨습니다.";
		} else {
			this.result = "아이디 및 패스워드를 확인하지 못하였습니다.";
		}
		return this.result;
	}
	
	public String corps(String id, String pw, String no) {	// 사업자회원
		if(id == "sm" && pw == "sm1234" && no == "134653478") {
			this.result = "로그인 하셨습니다.";
		} else {
			this.result = "아이디 및 패스워드 및 사업자 번호를 확인하지 못하였습니다.";
		};
		return this.result;
	}
}
