package js;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnect {
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		String db_driver = "com.mysql.cj.jdbc.Driver";  
		String db = "jdbc:mysql://localhost:3306/mobile_shop?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "coupang";
		String pw = "c1004";
		
		Class.forName(db_driver);			
		Connection conn = DriverManager.getConnection(db,user,pw);
		
		return conn;
	}
}
