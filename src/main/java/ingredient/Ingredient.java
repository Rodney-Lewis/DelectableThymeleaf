package ingredient;

class Ingredient {

	int ID;
	String name;
	String type;
	String description;
	float servingSize;
	int calories;
	String servingSizeType;
	
	Ingredient(int ID, String name, String type, String description,
			float servingSize, int calories, String servingSizeType)
	{
		this.ID = ID;
		this.name = name;
		this.type = type;
		this.description = description;
		this.servingSize = servingSize;
		this.calories = calories;
		this.servingSizeType = servingSizeType;
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
