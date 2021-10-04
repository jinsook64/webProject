package dit.web05.filter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");

		//폼에서 데이터를 가져오기
		String title = request.getParameter("title");
		String publisher= request.getParameter("publisher");
		String author = request.getParameter("author");
		
		//request 저장소에 가져온 데이터를 저장
		request.setAttribute("title",title);
		request.setAttribute("author",author);
		request.setAttribute("publisher",publisher);

		RequestDispatcher rd =request.getRequestDispatcher("/bookout.jsp"); 
		rd.forward(request, response);

	}

}
