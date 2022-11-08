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

import BO.FindMyset;
import BO.JudgeProbabilityLogic;
import BO.MysetRegisterLogic;
import BO.SetProbabilityLogic;
import BO.SetRarityLogic;
import Entity.Contents;
import Entity.User;

@WebServlet("/MysetRegister")
public class MysetRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		String name = request.getParameter("name");
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
			List<Double> probability = SPL.execute(rarity.size(), pr);
			
			JudgeProbabilityLogic JPL = new JudgeProbabilityLogic();
			boolean isPro = JPL.execute(probability);
			if(isPro) {
				if(name != null && name.length() != 0) {
					Contents contents = new Contents(rarity, probability);
					MysetRegisterLogic MRL = new MysetRegisterLogic();
					boolean isMRL = MRL.execute(loginUser, name, contents);
					if(isMRL) {
						FindMyset FM = new FindMyset();
						List<String> mysetNames = FM.execute(loginUser);
						session.setAttribute("mysetNames", mysetNames);
						session.setAttribute("contents", contents);
						request.setAttribute("name", name);
						RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/mysetRegisterResult.jsp");
						d.forward(request, response);
					} else {
						String error = "※同じマイセット名は登録出来ません";
						request.setAttribute("errorName", error);
						request.setAttribute("name", name);
						request.setAttribute("ra", ra);
						request.setAttribute("pr", pr);
						RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
						d.forward(request, response);
					}
				} else {
					String error = "※マイセット名を入力してください";
					request.setAttribute("error", error);
					request.setAttribute("ra", ra);
					request.setAttribute("pr", pr);
					RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
					d.forward(request, response);
				}
			} else {
				String error = "※各レアリティの合計が100%ではありません";
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
