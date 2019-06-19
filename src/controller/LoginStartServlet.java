package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginstart")
public class LoginStartServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException{
		String err = (String)request.getAttribute("err");
		
		request.setAttribute("err", err);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
	}

}
