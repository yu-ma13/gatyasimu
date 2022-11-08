package BO;

import java.util.List;

public class JudgeProbabilityLogic {
	public boolean execute(List<Double> pr) {
		double judge = 0;
		for(int i = 0; i < pr.size(); i++) {
			judge += pr.get(i);
		}
		if(judge == 100.0) {
			return true;
		}
		return false;
	}
}