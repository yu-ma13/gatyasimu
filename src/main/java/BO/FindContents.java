package BO;

import DAO.MysetDAO;
import Entity.Contents;
import Entity.User;

public class FindContents {
	public Contents execute(User loginUser, String name) {
		MysetDAO dao = new MysetDAO();
		Contents contents = dao.findContents(loginUser, name);
		return contents;
	}
}