package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.GatyaLogic;
import BO.GatyaTenLogic;
import BO.JudgeProbabilityLogic;
import BO.SetProbabilityLogic;
import BO.SetRarityLogic;
import Entity.Contents;
import Entity.Money;

@WebServlet("/GatyaTen")
public class GatyaTen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<String> ra = new ArrayList<>();
		List<String> pr = new ArrayList<>();
		
		ra.add(request.getParameter("ra1"));
		ra.add(request.getParameter("ra2"));
		ra.add(request.getParameter("ra3"));
		ra.add(request.getParameter("ra4"));
		ra.add(request.getParameter("ra5"));
		
		pr.add(request.getParameter("pr1"));
		pr.add(request.getParameter("pr2"));
		pr.add(request.getParameter("pr3"));
		pr.add(request.getParameter("pr4"));
		pr.add(request.getParameter("pr5"));
		
		if(ra.get(0) != null && ra.get(0).length() != 0 
				&& pr.get(0) != null && pr.get(0).length() != 0) {
			SetRarityLogic SRL = new SetRarityLogic();
			List<String> rarity = SRL.execute(ra);
			SetProbabilityLogic SPL = new SetProbabilityLogic();
			try {
				List<Double> probability = SPL.execute(rarity.size(), pr);
				JudgeProbabilityLogic JPL = new JudgeProbabilityLogic();
				boolean isPro = JPL.execute(probability);
				if(isPro) {
					HttpSession session = request.getSession();
					Contents contents = (Contents) session.getAttribute("contents");
					GatyaLogic GL = new GatyaLogic();
					List<String> result = GL.execute(contents.getRarity(), contents.getProbability(), 10);
					GatyaTenLogic GTL = new GatyaTenLogic();
					result.set(9, GTL.execute(rarity, probability));
					
					String moneyText = request.getParameter("money");
					if(moneyText != null && moneyText.length() != 0) {
						int moneyNum = Integer.parseInt(moneyText) * 10;
						Money money = (Money) session.getAttribute("money");
						money.sumMoney(moneyNum);
						request.setAttribute("money", money);
					}
					request.setAttribute("result", result);
					RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/gatyaTenResult.jsp");
					d.forward(request, response);
				} else {
					String error = "※各レアリティの合計が100%ではありません";
					request.setAttribute("error", error);
					request.setAttribute("ra", ra);
					request.setAttribute("pr", pr);
					RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
					d.forward(request, response);
				}
			} catch(Exception e) {
				String error = "※入力に不備があります";
				request.setAttribute("error", error);
				request.setAttribute("ra", ra);
				request.setAttribute("pr", pr);
				RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
				d.forward(request, response);
			}
		} else {
			String error = "※入力に不備があります";
			request.setAttribute("error", error);
			request.setAttribute("ra", ra);
			request.setAttribute("pr", pr);
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			d.forward(request, response);
		}
	}

}
