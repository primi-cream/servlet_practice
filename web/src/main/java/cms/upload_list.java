package cms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// review 내용 출력 및 이미지 data load
public class upload_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	dbconfig db = new dbconfig();
	private Connection con = null;
	private Statement st = null;
	private RequestDispatcher rd = null;
	private ResultSet rs = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.con = this.db.info();
			String sql = "SELECT * FROM filelist ORDER BY fidx desc limit 0,1";
			this.st = this.con.createStatement();
			this.rs = this.st.executeQuery(sql);
			this.rs.next();
			int fidx = this.rs.getInt(1);
			String f_img = this.rs.getString("f_img");
			String f_text = this.rs.getString("f_text");
			Date f_indate = this.rs.getDate("f_indate");
			
			//sql에 대한 데이터를 배열에 저장
			ArrayList<Object> list = new ArrayList<Object>();
			list.add(fidx);
			list.add(f_img);
			list.add(f_text);
			list.add(f_indate);
			request.setAttribute("list", list);	// 배열 전체를 jsp로 전달
//			request.setAttribute("fidx", fidx);
//			request.setAttribute("f_img", f_img);
//			request.setAttribute("f_text", f_text);
//			request.setAttribute("f_indate", f_indate);
			
//			System.out.println(fidx);
//			System.out.println(f_img);
//			System.out.println(f_text);
//			System.out.println(f_indate);
			
		} catch(Exception e) {
			System.out.println("DB 오류!");
		} finally {
			try {
				this.rs.close();
				this.st.close();
				this.con.close();
			} catch(Exception e) {
				System.out.println("DB 오류!");
			}
		}
		
		//getRequestDispatchaer (view 역할) : 코드에 제일 아래에 호출을 해야만 정상적으로 attribute가 작동함
		this.rd = request.getRequestDispatcher("./upload_list.jsp");
		this.rd.forward(request, response);
	}

}
