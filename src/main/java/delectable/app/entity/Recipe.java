package delectable.app.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private Time prepTime;
	private Time cookTime;
	private String directions;
	private String source;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "recipe_prodct", joinColumns = { @JoinColumn(name = "recipe_id") }, inverseJoinColumns = {
			@JoinColumn(name = "product_id") })
	private List<Product> products = new ArrayList<Product>();

	public Recipe() {
		super();
	}

	public Recipe(int id, String name, String description, Time prepTime, Time cookTime, String directions,
			String source, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.prepTime = prepTime;
		this.cookTime = cookTime;
		this.directions = directions;
		this.source = source;
		this.products = products;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Time getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(Time prepTime) {
		this.prepTime = prepTime;
	}

	public Time getCookTime() {
		return cookTime;
	}

	public void setCookTime(Time cookTime) {
		this.cookTime = cookTime;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<Product> getIngredients() {
		return products;
	}

	public void setIngredients(List<Product> recipe_ingredients) {
		this.products = recipe_ingredients;
	}
}
