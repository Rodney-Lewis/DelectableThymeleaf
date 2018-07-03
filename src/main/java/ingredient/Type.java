package ingredient;

public enum Type {

	DRY("Dry"),
	WET("Wet");
	
	private final String name;
	
	private Type(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
