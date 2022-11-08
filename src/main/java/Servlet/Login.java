package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.FindMyset;
import BO.LoginLogic;
import Entity.Money;
import Entity.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		if(loginUser != null) {
			Money money = new Money();
			FindMyset FM = new FindMyset();
			List<String> mysetNames = FM.execute(loginUser);
			session.setAttribute("mysetNames", mysetNames);
			session.setAttribute("money", money);
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			d.forward(request, response);
		} else {
			response.sendRedirect("/gatyasimu/");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		LoginLogic LL = new LoginLogic();
		User user = LL.execute(name, pass);
		if(user != null) {
			Money money = new Money();
			FindMyset FM = new FindMyset();
			List<String> mysetNames = FM.execute(user);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			session.setAttribute("money", money);
			session.setAttribute("mysetNames", mysetNames);
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			d.forward(request, response);
		} else {
			String[] error = {"※ログインに失敗しました。", " ユーザー名、パスワードを見直しください"};
			request.setAttribute("error", error);
			request.setAttribute("name", name);
			RequestDispatcher d = request.getRequestDispatcher("/index.jsp");
			d.forward(request, response);
		}
	}

}
