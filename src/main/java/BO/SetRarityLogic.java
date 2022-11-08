package BO;

import java.util.ArrayList;
import java.util.List;

public class SetRarityLogic {
	public List<String> execute(List<String> str) {
		List<String> ra = new ArrayList<>();
		
		for(int i = 0; i < str.size(); i++) {
			if(str.get(i) != null && str.get(i).length() != 0) {
				ra.add(str.get(i));
			}
		}
		
		return ra;
	}
}