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

import BO.GatyaLogic;
import Entity.Contents;
import Entity.Money;

@WebServlet("/Gatya")
public class Gatya extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String gatyaText = request.getParameter("gatya");
		if(gatyaText != null && gatyaText.length() != 0) {
			int gatyaNum = Integer.parseInt(gatyaText);
			if(gatyaNum <= 0 || gatyaNum > 100) {
				String error = "※入力に不備があります";
				request.setAttribute("error", error);
				RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/gatya.jsp");
				d.forward(request, response);
			} else {
				HttpSession session = request.getSession();
				Contents contents = (Contents) session.getAttribute("contents");
				
				GatyaLogic GL = new GatyaLogic();
				List<String> result = GL.execute(contents.getRarity(), contents.getProbability(), gatyaNum);
				
				String moneyText = request.getParameter("money");
				if(moneyText != null && moneyText.length() != 0) {
					int moneyNum = Integer.parseInt(moneyText);
					moneyNum *= gatyaNum;
					Money money = (Money) session.getAttribute("money");
					money.sumMoney(moneyNum);
					request.setAttribute("money", money);
				}
				request.setAttribute("result", result);
				request.setAttribute("loop", gatyaNum - 1);
				RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/gatyaResult.jsp");
				d.forward(request, response);
			}
		} else {
			String error = "※試行回数が入力されていません";
			request.setAttribute("error", error);
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/gatya.jsp");
			d.forward(request, response);
		}
	}

}
