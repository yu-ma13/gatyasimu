package BO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GatyaLogic {
	public List<String> execute(List<String> str, List<Double> dou, int n) {
		List<String> result = new ArrayList<>();
		List<Double> sort = new ArrayList<>();
		double target = 0;
		
		for(int i = 0; i < dou.size(); i++) {
			sort.add(dou.get(i));
		}
		
		Collections.sort(sort);
		
		for(int i = 0; i < n; i++) {
			result.add(null);
			double d = Math.random();
			
			for(int m = 0; m < dou.size(); m++) {
				if(d < sort.get(m) / 100) {
					target = sort.get(m);
					break;
				} else {
					target = sort.get(m);
				}
			}
			
			for(int m = 0; m < dou.size(); m++) {
				if(target == dou.get(m)) {
					
					if(result.get(i) == null) {
						result.set(i, str.get(m));
					}else {
						int r = new Random().nextInt(2);
						if(r == 1) {
							result.set(i, str.get(m));
						}
					}
					
				}
			}
		}
		return result;
	}
}