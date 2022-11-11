package BO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GatyaTenLogic {
	public String execute(List<String> str, List<Double> dou) {
		String result = "";
		List<Double> sort = new ArrayList<>();
		double target = 0;
		
		for(int i = 0; i < dou.size(); i++) {
			sort.add(dou.get(i));
		}
		
		Collections.sort(sort);
		
		double d = Math.random();
			
		for(int i = 0; i < dou.size(); i++) {
			if(d < sort.get(i) / 100) {
				target = sort.get(i);
				break;
			} else {
				target = sort.get(i);
			}
		}
			
		for(int i = 0; i < dou.size(); i++) {
			if(target == dou.get(i)) {
					
				if(result.equals("")) {
					result = str.get(i);
				}else {
					int r = new Random().nextInt(2);
					if(r == 1) {
						result = str.get(i);
					}
				}
					
			}
		}
		
		return result;
	}
}