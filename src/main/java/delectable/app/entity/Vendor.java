package delectable.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import delectable.app.entity.secondary.VendorOpenHours;
import delectable.app.utility.Day;

@Entity
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String phoneNumber;
	String address;
	String website;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vendor")
	private List<VendorOpenHours> hours = new ArrayList<VendorOpenHours>(6);

	public Vendor() {
		super();
		for (Day days : Day.values()) {
			hours.add(new VendorOpenHours(this, days.toString(), "08:00:00", "17:00:00"));
		}
	}

	public Vendor(int id, String name, String phoneNumber, String address, String website,
			List<VendorOpenHours> hours) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.website = website;
		this.hours = hours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<VendorOpenHours> getHours() {
		return hours;
	}

	public void setHours(List<VendorOpenHours> hours) {
		this.hours = hours;
	}

}
