package js;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class gameok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String point[][] = {
		                {"500포인트","5000포인트","꽝","3000포인트","2000포인트","1000포인트"},
		                {"500","5000","0","3000","2000","1000"}
		};
		
		String result = request.getParameter("result");
		String mid = request.getParameter("mid");
		String mname = request.getParameter("mname");
		
		String game[] = result.split(",");
		System.out.println(Arrays.toString(game));
		System.out.println(game.length);
		try {
			dbconnect dc = new dbconnect();
			Connection conn = dbconnect.getConnection();
			System.out.println("Database가 정상 연결되었습니다.");
			PreparedStatement ps = null;
			String coupon_name = "";
			String point_value = "";
			
			int w = 0;
			while(w < game.length) {	//3
				int ww=0;
				while(ww < point[0].length) {
					if(game[w].equals(point[0][ww])) {
						coupon_name = point[0][ww];
						point_value = point[1][ww];
						String sql = "INSERT INTO game VALUES ('0','"+ mid +"','"+ mname +"','" + coupon_name + "','"+ point_value +"',now())";
						ps = conn.prepareStatement(sql);
						ps.executeUpdate();
						break;
					}
					ww++;
				}
				w++;
			}
			System.out.println("test : " + mid + " name : " + mname + "c: " + coupon_name + " p : " + point_value);
			System.out.println("룰렛 게임에 대한 당첨 사항을 포인트로 지급 되었습니다.");
			ps.close();
			conn.close();
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("Database의 정보가 올바르지 않습니다.");
		}
	}

}
