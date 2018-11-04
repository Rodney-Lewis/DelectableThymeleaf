package delectable.app.entity;

import java.sql.Time;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@Size(min = 1, max = 25)
	private String name;

	@Size(min = 0, max = 254)
	private String description;

	private Time prepTime;
	private Time cookTime;

	private String directions;
	private String source;

	private ArrayList<Product> ingredients;

	public Recipe() {
		super();
	}

	public Recipe(int id, @NotNull @Size(min = 1, max = 25) String name, @Size(min = 0, max = 254) String description,
			Time prepTime, Time cookTime, String directions, String source, ArrayList<Product> ingredients) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.prepTime = prepTime;
		this.cookTime = cookTime;
		this.directions = directions;
		this.source = source;
		this.ingredients = ingredients;
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

	public ArrayList<Product> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Product> ingredients) {
		this.ingredients = ingredients;
	}
}
