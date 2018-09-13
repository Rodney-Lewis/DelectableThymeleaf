package product;

class Nutrient {

	int id;
	String name;
	float value;
	String unitOfMeasure;
	
	public Nutrient(int id, String name, float value, String unitOfMeasure) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.unitOfMeasure = unitOfMeasure;
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
	
	public float getValue() {
		return value;
	}
	
	void setValue(float value) {
		this.value = value;
	}
	
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}
	
	void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
}
