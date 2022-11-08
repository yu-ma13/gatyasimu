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

import BO.FindContents;
import BO.ListProbabilityLogic;
import BO.ListRarityLogic;
import Entity.Contents;
import Entity.User;

@WebServlet("/Myset")
public class Myset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		FindContents FC = new FindContents();
		Contents contents = FC.execute(loginUser, name);
		ListRarityLogic LRL = new ListRarityLogic();
		List<String> ra = LRL.execute(contents.getRarity());
		ListProbabilityLogic LPL = new ListProbabilityLogic();
		List<String> pr = LPL.execute(contents.getProbability());
		request.setAttribute("ra", ra);
		request.setAttribute("pr", pr);
		request.setAttribute("mysetName", name);
		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
		d.forward(request, response);
	}

}
