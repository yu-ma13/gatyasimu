package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Contents implements Serializable {
	private List<String> rarity = new ArrayList<>();
	private List<Double> probability = new ArrayList<>();
	
	public Contents() {}
	
	public Contents(List<String> str, List<Double> num) {
		this.rarity = str;
		this.probability = num;
	}
	
	public List<String> getRarity() {
		return rarity;
	}
	public void setRarity(String s) {
		rarity.add(s);
	}
	
	public List<Double> getProbability() {
		return probability;
	}
	public void setProbability(double d) {
		probability.add(d);
	}
}