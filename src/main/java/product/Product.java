package product;

import java.util.ArrayList;

import vendor.Vendor;

class Product {

	int id;
	String name;
	String brand;
	float servingSize;
	String unitOfMeasure;
	int calories;
	String ingredients;
	boolean ingredient;
	boolean premade;
	ArrayList<Nutrient> nutrients = new ArrayList<Nutrient>();
	ArrayList<Vendor> vendors = new ArrayList<Vendor>();
	
	public Product() {
		super();
	}
	
	public Product(int id, String name, String brand, float servingSize, String unitOfMeasure, int calories,
			String ingredients, boolean ingredient, boolean premade) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.servingSize = servingSize;
		this.unitOfMeasure = unitOfMeasure;
		this.calories = calories;
		this.ingredients = ingredients;
		this.ingredient = ingredient;
		this.premade = premade;
	}
	
	public Product(int id, String name, String brand, float servingSize, String unitOfMeasure, int calories,
			String ingredients, boolean ingredient, boolean premade, ArrayList<Nutrient> nutrients,
			ArrayList<Vendor> vendors) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.servingSize = servingSize;
		this.unitOfMeasure = unitOfMeasure;
		this.calories = calories;
		this.ingredients = ingredients;
		this.ingredient = ingredient;
		this.premade = premade;
		this.nutrients = nutrients;
		this.vendors = vendors;
	}

	public int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	void setBrand(String manufacturer) {
		this.brand = manufacturer;
	}

	public float getServingSize() {
		return servingSize;
	}

	void setServingSize(float servingSize) {
		this.servingSize = servingSize;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public int getCalories() {
		return calories;
	}

	void setCalories(int calories) {
		this.calories = calories;
	}

	public String getIngredients() {
		return ingredients;
	}

	void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public boolean isIngredient() {
		return ingredient;
	}

	void setIngredient(boolean ingredient) {
		this.ingredient = ingredient;
	}

	public boolean isPremade() {
		return premade;
	}

	void setPremade(boolean premade) {
		this.premade = premade;
	}

	public ArrayList<Nutrient> getNutrients() {
		return nutrients;
	}

	void setNutrients(ArrayList<Nutrient> nutrients) {
		this.nutrients = nutrients;
	}

	public ArrayList<Vendor> getVendors() {
		return vendors;
	}

	void setVendors(ArrayList<Vendor> vendors) {
		this.vendors = vendors;
	}
}
