package vendor;

import java.util.Calendar;

public class Vendor {
	int id;
	String name;
	//Calendar [][] hours = new Calendar[7][7];
	String phoneNumber;
	String address;
	String website;
	
	public Vendor(int id, String name, Calendar[][] hours, String phoneNumber, String address, String website) {
		super();
		this.id = id;
		this.name = name;
		//this.hours = hours;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.website = website;
	}
}
