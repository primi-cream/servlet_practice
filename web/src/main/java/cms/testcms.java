	package cms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class testcms extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	dbconfig db = new dbconfig();
	PrintWriter pw = null;
	Connection con = null;	// mysql 접속 승인 및 DML, DDL, DCL 사용하기 위함
	
	//Controller part
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.con = db.info();
			System.out.println("Database 접속 성공☆");
			String tables = "review";
//			String sql = "drop table " + tables;
//			String sql = "CREATE TABLE " + tables + "("
//					+ "nidx int(5) not null auto_increment,"
//					+ "mid varchar(30) not null,"
//					+ "primary key(nidx)"
//					+ ")";
			
			String sql = "INSERT INTO " + tables + " VALUES('0','hing')";
			//Statement st = this.con.createStatement();
			//boolean result = st.execute(sql);	// false
			
			//executeQuery() : select(Result - 배열)
			//executeUpdate() : insert, update, delete (int, Integer)
			//execute : create, drop, alter ,insert, update, delete  (false), select (true)
			PreparedStatement st = this.con.prepareStatement(sql);
			int result = st.executeUpdate();
			if(result > 0) {
				System.out.println("정상적으로 테이블이 생성되었습니다.");
			}
		} catch (SQLSyntaxErrorException see) {
			System.out.println("중복 테이블 발생 및 SQL 문법 오류 발생");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Database 접속 오류!!");
		} finally {
			try {
				this.con.close(); // database 접속해제
			} catch (Exception e) {
				System.out.println("Database를 정상적으로 종료하지 못하였습니다.");
			}
		}
	}

}
