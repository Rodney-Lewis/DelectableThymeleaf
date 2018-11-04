package delectable.app.utility;

public class FractionHelper {

	static String ConvertFloatToFrac(float value) {
		
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
	
	static int FindGreatestCommonDenominator(int a, int b) {
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
