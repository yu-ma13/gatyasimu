package BO;

import DAO.UserDAO;
import Entity.User;

public class UserRegisterLogic {
	public boolean execute(User user, String name,String pass,String checkPass) {
		if(user == null &&
				name != null && name.length() != 0 
				&& pass != null && pass.length() != 0 
				&& pass.equals(checkPass)) {
			UserDAO dao = new UserDAO();
			dao.registerUser(name, pass);
			return true; 
		}
		return false;
	}
}