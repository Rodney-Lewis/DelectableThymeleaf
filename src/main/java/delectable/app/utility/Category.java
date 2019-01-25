package delectable.app.utility;

public enum Category {
	Dairy("Dairy"), Frozen("Frozen"), SpicesAndSeasoning("Spices and Seasoning"), MeatAndSeafood("Meat and Seafood"),
	Beverages("Beverages"), CondimentsAndToppings("Condiments and Toppings"), Produce("Produce");

	private String name;

	Category() {
	}

	Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
