package delectable.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Size(min = 1, max = 25)
	private String name;

	@NotNull
	@Size(min = 1, max = 25)
	private String brand;

	@NotNull
	@Min(0)
	// private float servingSize;
	private String unitOfMeasure;

	@NotNull
	@Min(0)
	private Integer calories;

	/*
	 * private boolean ingredient; private boolean premade;
	 * 
	 * private String ingredients; private ArrayList<Product> knownIngredients;
	 * private ArrayList<Nutrient> nutrients; private ArrayList<Vendor> vendors;
	 */
	public Product() {
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

	/*
	 * public float getServingSize() { return servingSize; }
	 * 
	 * public void setServingSize(float servingSize) { this.servingSize =
	 * servingSize; }
	 */

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

	/*
	 * public boolean isIngredient() { return ingredient; }
	 * 
	 * public void setIngredient(boolean ingredient) { this.ingredient = ingredient;
	 * }
	 * 
	 * public boolean isPremade() { return premade; }
	 * 
	 * public void setPremade(boolean premade) { this.premade = premade; }
	 * 
	 * public String getIngredients() { return ingredients; }
	 * 
	 * public void setIngredients(String ingredients) { this.ingredients =
	 * ingredients; }
	 * 
	 * public ArrayList<Product> getKnownIngredients() { return knownIngredients; }
	 * 
	 * public void setKnownIngredients(ArrayList<Product> knownIngredients) {
	 * this.knownIngredients = knownIngredients; }
	 * 
	 * public ArrayList<Nutrient> getNutrients() { return nutrients; }
	 * 
	 * public void setNutrients(ArrayList<Nutrient> nutrients) { this.nutrients =
	 * nutrients; }
	 * 
	 * public ArrayList<Vendor> getVendors() { return vendors; }
	 * 
	 * public void setVendors(ArrayList<Vendor> vendors) { this.vendors = vendors; }
	 */
}
