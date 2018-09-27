package product;

public enum UnitOfMeasure {

	TEASPOON("Teaspoon", "tsp"),
	TABLESPOON("Tablespoon", "tbsp"),
	FLUID_OUNCE("Fluid Ounce", "fl oz"),
	CUP("Cup", "c"),
	PINT("Pint", "pt"),
	QUART("Quart", "qt"),
	GALLON("Gallon", "gal"),
	MILLILITER("Milliliter", "mL"),
	LITER("Liter", "L"),
	POUND("Pound", "lb"),
	OUNCE("Ounce", "oz"),
	MILLIGRAM("Milligram", "mg"),
	GRAM("Gram", "g"),
	KILOGRAM("Kilogram", "kg"),
	SLICE("Slice", "sli"),
	PACKAGE("Package", "Pac");
	
	
	private final String name;
	private final String abbreviation;
	
	private UnitOfMeasure(String name, String abbreviation ) {
		this.name = name;
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
}
