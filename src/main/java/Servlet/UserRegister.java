package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.FindUser;
import BO.UserRegisterLogic;
import Entity.User;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp");
		d.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String checkPass = request.getParameter("checkPass");
		FindUser FU = new FindUser();
		User user = FU.execute(name);
		
		UserRegisterLogic URL = new UserRegisterLogic();
		boolean isRegister = URL.execute(user, name, pass, checkPass);
		if(isRegister) {
			request.setAttribute("name", name);
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/userRegisterResult.jsp");
			d.forward(request, response);
		} else {
			if(name == null || name.length() == 0) {
				request.setAttribute("nameNull", "※名前が入力されていません");
			} else if(user != null) {
				request.setAttribute("errorName", "※そのユーザー名は既に使用されています");
			}
			if(pass == null || pass.length() == 0) {
				request.setAttribute("passNull", "※パスワードが入力されていません");
			} else if(!(pass.equals(checkPass))) {
				request.setAttribute("errorPass", "※パスワードが違います");
			}
			request.setAttribute("name", name);
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp");
			d.forward(request, response);
		}
	}

}
