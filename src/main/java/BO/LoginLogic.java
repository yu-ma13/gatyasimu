package BO;

import DAO.UserDAO;
import Entity.User;

public class LoginLogic {
	public User execute(String name, String pass) {
		UserDAO dao = new UserDAO();
		User user = dao.findUser(name);
		if(user != null && user.getPass().equals(pass)) {
			return user;
		}
		return null;
	}
}