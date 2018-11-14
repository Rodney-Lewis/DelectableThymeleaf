package delectable.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String phoneNumber;
	private String address;
	private String website;
	private boolean delivers;
	private boolean carryOut;

	public Restaurant() {
		super();
	}

	public Restaurant(int id, String name, String phoneNumber, String address, String website, boolean delivers,
			boolean carryOut) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.website = website;
		this.delivers = delivers;
		this.carryOut = carryOut;
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

	public boolean isDelivers() {
		return delivers;
	}

	public void setDelivers(boolean delivers) {
		this.delivers = delivers;
	}

	public boolean isCarryOut() {
		return carryOut;
	}

	public void setCarryOut(boolean carryOut) {
		this.carryOut = carryOut;
	}
}
