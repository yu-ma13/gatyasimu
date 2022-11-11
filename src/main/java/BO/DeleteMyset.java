package BO;

import java.util.List;

import DAO.MysetDAO;
import Entity.User;

public class DeleteMyset {
	public List<String> execute(User loginUser, String name) {
		MysetDAO dao = new MysetDAO();
		dao.deleteMyset(loginUser, name);
		FindMyset FM = new FindMyset();
		List<String> names = FM.execute(loginUser);
		return names;
	}
}