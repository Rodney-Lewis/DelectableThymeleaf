package delectable.app.entity.secondary;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import delectable.app.entity.Restaurant;

@Entity
public class RestaurantOpenHours {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id")
	Restaurant restaurant;
	String day;
	String openTime;
	String closeTime;

	public RestaurantOpenHours() {
		super();
	}

	public RestaurantOpenHours(Restaurant restaurant, String day, String openTime, String closeTime) {
		super();
		this.restaurant = restaurant;
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

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
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
