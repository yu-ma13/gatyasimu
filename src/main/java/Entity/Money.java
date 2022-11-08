package Entity;

import java.io.Serializable;

public class Money implements Serializable{
	private int money = 0;
	
	public Money() {}
	
	public int getMoney() {
		return money;
	}
	public void sumMoney(int money) {
		this.money += money;
	}
}