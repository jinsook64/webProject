package cs.dit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/list")
public class LController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Context initCtx=null;
		Context envCtx=null;
		DataSource ds=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		JSONArray list=null;
		
		try {
			request.setCharacterEncoding("utf-8");
			//커넥션 풀 사용한 DB 연동
			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/JSP");
			
			//커넥션 얻고 SQL 실행
			con = ds.getConnection();
			String sql = "select * from login";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//한글 처리
			response.setContentType("text/html; charset=utf-8");
			
			//JSON 배열 객체 생성	
			list = new JSONArray();
			
			while (rs.next()){
				JSONObject json = new JSONObject();
				json.put("id", rs.getString("id"));
				json.put("name",rs.getString("name"));
				json.put("pwd", rs.getString("pwd"));
				list.add(json);	//JSON 객체로 배열을 만듬
			}
			//JSON 배결 객체 클라이언트에 반환
			response.getWriter().print(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if(pstmt!=null)
				try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if(con!=null)
				try {con.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doHandle(request, response);
	}
}
