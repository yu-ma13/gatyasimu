package BO;

import java.util.List;

import DAO.MysetDAO;
import Entity.Contents;
import Entity.User;

public class MysetRegisterLogic {
	public boolean execute(User loginUser, String name, Contents contents) {
		MysetDAO dao = new MysetDAO();
		List<String> names = dao.findName(loginUser);
		for(int i = 0; i < names.size(); i++) {
			if(name.equals(names.get(i))) {
				return false;
			}
		}
		dao.registerMyset(loginUser, name, contents);
		return true;
	}
}