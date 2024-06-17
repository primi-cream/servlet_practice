package cms;
// Module : Database 접속 환경설정 파일
// 모든 Module은 Controller로 return 

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconfig {
	
	public Connection info() throws Exception{
		String db_driver = "com.mysql.cj.jdbc.Driver"; // lib -> java
	//	String db_driver = "com.mysql.jdbc.Driver";	// lib -> j		database 드라이브 연결 속성
		String db_url = "jdbc:mysql://172.30.1.41:3306/cms";	// JDBC : Java DataBase Connect 내부 : localhost, 외부 : ip또는 도메인명을 이용하여 접속
		String db_user = "hana";	//user id
		String db_pass = "hana1234";	//user pw
		
		// mysql
		Class.forName(db_driver); // 어떤 라이브러리를 이용하여 어떤 DB에 접속할 것인가를 말함
		// -u 아이디 -p
		Connection dbcon = DriverManager.getConnection(db_url,db_user,db_pass);
		
		return dbcon;
	}
}
