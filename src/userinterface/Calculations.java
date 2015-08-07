package userinterface;

public class Calculations {
	private double amount=5;
	private double amounted=0;
	private double amountek=55;
	private double amountms=0;
	private double amountrp=0;
	
	public void setamount(double amounts) {
		this.amount = amounts;
		this.amounted = amounts;
		this.amountek = amounts;
		this.amountms = amounts;
		this.amountrp = amounts;
	}
	
	public double getamounted() {
		return amounted*0.4;
	}
	
	public double getamountek() {
		return amountek*0.2;
	}
	
	public double getamountms() {
		return amountms*0.25;
	}
	
	public double getamountrp() {
		return amountrp*0.15;
	}
}
