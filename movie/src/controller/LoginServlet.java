package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LoginInfoBeans;
import model.LoginModel;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		
		///////////////////////
		//jspから学籍番号とパスワードを取得
		String id = request.getParameter("id");
		String passward = request.getParameter("passward");
		
		//////////////////////
		//modelの呼び出し
		LoginModel loginModel = new LoginModel();
		
		LoginInfoBeans loginInfo = loginModel.login(id,passward);
		
		
		if(loginInfo != null) {
		    /////////////////////
		    //ログイン結果をセッションに保存
			HttpSession session = request.getSession(true);
			
			session.setAttribute("loginInfo", loginInfo);
		}else {
			////////////////////
			//ログイン失敗時にログイン画面に戻す
			response.sendRedirect("loginstart?err=1");
			return;
		}
		
		////////////////////
		//画面を転送
		response.sendRedirect("top");
		
	}
}