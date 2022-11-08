package BO;

import java.util.ArrayList;
import java.util.List;

public class ListProbabilityLogic {
	public List<String> execute(List<Double> dou) {
		List<String> pr = new ArrayList<>();
		for(int i = 0; i < dou.size(); i++) {
			pr.add(String.valueOf(dou.get(i)));
		}
		if(pr.size() <= 5) {
			for(int i = 0; i < 5 - pr.size(); i++) {
				pr.add(null);
			}
		}
		return pr;
	}
}