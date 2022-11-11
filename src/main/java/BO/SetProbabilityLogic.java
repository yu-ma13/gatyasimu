package BO;

import java.util.ArrayList;
import java.util.List;

public class SetProbabilityLogic {
	public List<Double> execute(int n, List<String> dou) {
		List<Double> pr = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			pr.add(Double.parseDouble(dou.get(i)));
		}
		
		return pr;
	}
}