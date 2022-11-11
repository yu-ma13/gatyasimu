package BO;

import java.util.ArrayList;
import java.util.List;

public class ListRarityLogic {
	public List<String> execute(List<String> str) {
		List<String> ra = new ArrayList<>();
		for(int i = 0; i < str.size(); i++) {
			ra.add(str.get(i));
		}
		if(ra.size() <= 5) {
			for(int i = 0; i < 5 - ra.size(); i++) {
				ra.add(null);
			}
		}
		return ra;
	}
}