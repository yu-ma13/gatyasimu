package BO;

import java.util.List;

import DAO.MysetDAO;
import Entity.User;

public class FindMyset {
	public List<String> execute(User user) {
		MysetDAO dao = new MysetDAO();
		List<String> mysetNames = dao.findName(user);
		return mysetNames;
	}
}