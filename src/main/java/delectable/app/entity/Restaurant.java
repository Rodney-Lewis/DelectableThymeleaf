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

import delectable.app.entity.secondary.OpenHours;
import delectable.app.utility.Day;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String phoneNumber;
	private String address;
	private String website;
	private boolean delivery;
	private boolean carryOut;
	private boolean orderOnline;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "restaurant")
	private List<OpenHours> hours = new ArrayList<OpenHours>(6);

	public Restaurant() {
		super();

		for (Day days : Day.values()) {
			hours.add(new OpenHours(this, days.toString(), "08:00:00", "17:00:00"));
		}
	}

	public Restaurant(int id, String name, String phoneNumber, String address, String website, boolean delivery,
			boolean carryOut, boolean orderOnline, List<OpenHours> hours) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.website = website;
		this.delivery = delivery;
		this.carryOut = carryOut;
		this.orderOnline = orderOnline;
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

	public void setWebsite(String websiteMenu) {
		this.website = websiteMenu;
	}

	public boolean isDelivery() {
		return delivery;
	}

	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}

	public boolean isCarryOut() {
		return carryOut;
	}

	public void setCarryOut(boolean carryOut) {
		this.carryOut = carryOut;
	}

	public boolean isOrderOnline() {
		return orderOnline;
	}

	public void setOrderOnline(boolean orderOnline) {
		this.orderOnline = orderOnline;
	}

	public List<OpenHours> getHours() {
		return hours;
	}

	public void setHours(List<OpenHours> hours) {
		this.hours = hours;
	}

}
