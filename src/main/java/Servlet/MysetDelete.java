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

import BO.DeleteMyset;
import Entity.User;

@WebServlet("/MysetDelete")
public class MysetDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		List<String> mysetNames = (List<String>) session.getAttribute("mysetNames");
		if(loginUser != null && mysetNames != null) {
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/mysetDelete.jsp");
			d.forward(request, response);
		} else if(loginUser != null) {
			RequestDispatcher d = request.getRequestDispatcher("/Top");
			d.forward(request, response);
		} else {
			response.sendRedirect("/gatyasimu/");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		DeleteMyset DM = new DeleteMyset();
		List<String> mysetNames = DM.execute(loginUser, name);
		request.setAttribute("mysetNames", mysetNames);
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/mysetDelete.jsp");
		d.forward(request, response);
	}

}
