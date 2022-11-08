package BO;

import DAO.UserDAO;
import Entity.User;

public class FindUser {
	public User execute(String name) {
		UserDAO dao = new UserDAO();
		User user = dao.findUser(name);
		return user;
	}
}