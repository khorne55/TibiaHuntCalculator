package userinterface;

import java.io.FileWriter;
import java.io.IOException;

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
		return amounted*(sets1.pered/100);
	}
	
	public double getamountek() {
		return amountek*(sets1.perek/100);
	}
	
	public double getamountms() {
		return amountms*(sets1.perms/100);
	}
	
	public double getamountrp() {
		return amountrp*(sets1.perrp/100);
	}
	
	public void set(String logs) {
        try {
            String filename ="C:/Users/Khorne/Desktop/HuntLog1.log";
            FileWriter log = new FileWriter(filename,true);
            log.write(logs);
            log.write(System.lineSeparator());
            log.close();

       } catch (SecurityException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
        
      
        
   }
	}

