package userinterface;

public class Calculations {
	Settings sets1;
	
	private double amount=5;
	private double amounted=0;
	private double amountek=0;
	private double amountms=0;
	private double amountrp=0;
	
	
	public void setamount(double amounts) {
		this.amount = amounts;
		this.amounted = amounts;
		this.amountek = amounts;
		this.amountms = amounts;
		this.amountrp = amounts;
	}
	
	public void update() {
	   sets1 = new Settings();
	}
	
	public double getamounted() {
		return amounted*sets1.pered;
	}
	
	public double getamountek() {
		return amountek*sets1.perek;
	}
	
	public double getamountms() {
		return amountms*sets1.perms;
	}
	
	public double getamountrp() {
		return amountrp*sets1.perrp;
	}
}
