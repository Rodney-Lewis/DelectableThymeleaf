package product;

import java.util.ArrayList;

import vendor.Vendor;

class Product {

	int id;
	String name;
	String manufacturer;
	float servingSize;
	String unitOfMeasure;
	int calories;
	String ingredients;
	boolean ingredient;
	boolean premade;
	ArrayList<Nutrient> nutrients;
	ArrayList<Vendor> vendors;
	
	public Product(int id, String name, String manufacturer, float servingSize, String unitOfMeasure, int calories,
			String ingredients, boolean ingredient, boolean premade) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.servingSize = servingSize;
		this.unitOfMeasure = unitOfMeasure;
		this.calories = calories;
		this.ingredients = ingredients;
		this.ingredient = ingredient;
		this.premade = premade;
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

	public String getManufacturer() {
		return manufacturer;
	}

	void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
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

	String ConvertFloatToFrac(float value) {
		
		int numberOfDecimalPlaces = 0;
		int multiplicationFactor;
		int numerator;
		int GreatestCommonDenominator;
		int denominator;
		String fraction = "";
		
		numberOfDecimalPlaces = Float.toString(value).indexOf('.') -  Float.toString(value).length() - 1;
		multiplicationFactor = (int) Math.pow(10, numberOfDecimalPlaces);
		numerator = (int) (value * multiplicationFactor);
		
		GreatestCommonDenominator = FindGreatestCommonDenominator(numerator, multiplicationFactor);
		
		numerator = numerator / GreatestCommonDenominator;
		denominator = multiplicationFactor / GreatestCommonDenominator;
		
		fraction = Integer.toString(numerator) + '/' + Integer.toString(denominator);
		return fraction;
	}
	
	int FindGreatestCommonDenominator(int a, int b) {
		//Euclidean division
		int temp;
		while(b != 0) {
			temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
