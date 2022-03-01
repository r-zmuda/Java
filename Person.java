package person;

import java.util.Date;

public class Person {
	
	private String name;
	private String address;
	private String eyecolor;
	private double height;
	private double weight;
	private Date birthdate;
	
	// create a new person object.  
	public Person(String nm, String ad, String eye, double ht, double wt) {
		name = nm;
		address = ad;
		eyecolor = eye;
		
		if(ht <= 0) {
			ht = 1;
		}
		if(wt <= 0) {
			wt = 1;
		}
		
		height = ht;
		weight = wt;
		birthdate = new Date();
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}

	public String getEyeColor() {
		return eyecolor;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getAge() {
		Date curdate = new Date();
		
		long milliseconds = curdate.getTime() - birthdate.getTime();
		
		int days = (int) (milliseconds / (1000*60*60*24));
		return days/365.0;
	}
	
	public double getBMI() {
		// need to calculate BMI
		return weight / ((height * 12) * (height * 12)) * 703;
	}
	
	public boolean isseniorCitizen() {
		return getAge() >= 65;
	}
	
	public String toString() {
		return name + " " + address +" "+ birthdate +" Age = "+ getAge() +" BMI = "+ getBMI();
	}

	

}


