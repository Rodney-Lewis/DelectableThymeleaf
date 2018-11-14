package delectable.app.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String brand;
	private float servingSize;
	private String unitOfMeasure;
	private int calories;
	private boolean ingredient;
	private boolean premade;
	private String ingredients;
	private ArrayList<Product> knownIngredients;
	private ArrayList<Nutrient> nutrients;
	private ArrayList<Vendor> vendors;

	public Product() {
	}

	public Product(int id, String name, String brand, float servingSize, String unitOfMeasure, int calories,
			boolean ingredient, boolean premade, String ingredients, ArrayList<Product> knownIngredients,
			ArrayList<Nutrient> nutrients, ArrayList<Vendor> vendors) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.servingSize = servingSize;
		this.unitOfMeasure = unitOfMeasure;
		this.calories = calories;
		this.ingredient = ingredient;
		this.premade = premade;
		this.ingredients = ingredients;
		this.knownIngredients = knownIngredients;
		this.nutrients = nutrients;
		this.vendors = vendors;
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

	public boolean isIngredient() {
		return ingredient;
	}

	public void setIngredient(boolean ingredient) {
		this.ingredient = ingredient;
	}

	public boolean isPremade() {
		return premade;
	}

	public void setPremade(boolean premade) {
		this.premade = premade;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public ArrayList<Product> getKnownIngredients() {
		return knownIngredients;
	}

	public void setKnownIngredients(ArrayList<Product> knownIngredients) {
		this.knownIngredients = knownIngredients;
	}

	public ArrayList<Nutrient> getNutrients() {
		return nutrients;
	}

	public void setNutrients(ArrayList<Nutrient> nutrients) {
		this.nutrients = nutrients;
	}

	public ArrayList<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(ArrayList<Vendor> vendors) {
		this.vendors = vendors;
	}

}
