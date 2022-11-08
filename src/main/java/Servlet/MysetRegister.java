package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.MysetRegisterLogic;
import dao.MysetDAO;
import entity.Contents;
import entity.User;

@WebServlet("/MysetRegister")
public class MysetRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		Contents contents = (Contents) session.getAttribute("contents");
		if(loginUser != null && contents != null) {
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/mysetRegister.jsp");
			d.forward(request, response);
		} else if(loginUser != null) {
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
			d.forward(request, response);
		} else {
			response.sendRedirect("/gatyaSimu/");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		Contents contents = (Contents) session.getAttribute("contents");
		
		if(name != null && name.length() != 0) {
			MysetDAO dao = new MysetDAO();
			List<String> names = dao.findName(loginUser);
			MysetRegisterLogic MRL = new MysetRegisterLogic();
			boolean isMRL = MRL.execute(names, name);
			if(isMRL) {
				dao.registerMyset(loginUser, name, contents);
				int loop = contents.getRarity().size() - 1;
				request.setAttribute("loop", loop);
				request.setAttribute("name", name);
				RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/mysetRegisterResult.jsp");
				d.forward(request, response);
			} else {
				String error = "※同じマイセット名は登録出来ません";
				request.setAttribute("errorName", error);
				request.setAttribute("name", name);
				RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/mysetRegister.jsp");
				d.forward(request, response);
			}
		} else {
			String error = "※マイセット名を入力してください";
			request.setAttribute("error", error);
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/mysetRegister.jsp");
			d.forward(request, response);
		}
	}

}
