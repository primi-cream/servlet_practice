package shop;
//database 접속 아이디 및 패스워드 설정 class

import java.sql.Connection;
import java.sql.DriverManager;

public class dbinfo {
	public static Connection getConnection() throws Exception{
		String dbinfo = "com.mysql.cj.jdbc.Driver";
		String dburl = "jdbc:mysql://172.30.1.85:3306/easymall";
		String dbuser = "easy";
		String dbpass = "easy1234";
		
		
		Class.forName(dbinfo);
		Connection con = DriverManager.getConnection(dburl,dbuser,dbpass);
		
		
		return con;
	}
}
