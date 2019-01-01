package delectable.app.entity.secondary;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import delectable.app.entity.Vendor;

@Entity
public class VendorOpenHours {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendor_id")
	Vendor vendor;
	String day;
	String openTime;
	String closeTime;

	public VendorOpenHours() {
		super();
	}

	public VendorOpenHours(Vendor vendor, String day, String openTime, String closeTime) {
		super();
		this.vendor = vendor;
		this.day = day;
		this.openTime = openTime;
		this.closeTime = closeTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

}
