package delectable.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String brand;
	private String category;
	private float servingSize;
	private String unitOfMeasure;
	private int calories;
	private boolean ingredient;
	private String prepTime;
	private String cookTime;
	private String directions;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	private List<Vendor> vendor;

	public Product() {
	}

	public Product(int id, String name, String brand, String category, float servingSize, String unitOfMeasure,
			int calories, boolean ingredient) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.servingSize = servingSize;
		this.unitOfMeasure = unitOfMeasure;
		this.calories = calories;
		this.setIngredient(ingredient);
	}

	public Product(int id, String name, String brand, String category, float servingSize, String unitOfMeasure,
			int calories, boolean ingredient, String prepTime, String cookTime, String directions) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.servingSize = servingSize;
		this.unitOfMeasure = unitOfMeasure;
		this.calories = calories;
		this.setIngredient(ingredient);
		this.prepTime = prepTime;
		this.cookTime = cookTime;
		this.directions = directions;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getServingSize() {
		return servingSize;
	}

	public void setServingSize(float servingSize) {
		this.servingSize = servingSize;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public String getCookTime() {
		return cookTime;
	}

	public void setCookTime(String cookTime) {
		this.cookTime = cookTime;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public boolean isIngredient() {
		return ingredient;
	}

	public void setIngredient(boolean ingredient) {
		this.ingredient = ingredient;
	}

}
