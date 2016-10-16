package is.ru.stringcalculator;
import java.util.List;
import java.util.ArrayList;

public class Calculator {

	public static int add(String text){
		if(text.equals(""))
			return 0;
		else if(text.contains(",") || text.contains("\n")) {
			return sum(splitNumbers(text));
		}
		else	
			return 1;
	}
	private static int toInt(String text) {
		return Integer.parseInt(text);
	}

	private static String[] splitNumbers(String numbers) {
		return numbers.split(",|\n");
	}

	private static int sum(String[] numbers) {
		int total = 0;
		List<String> negativeNumbers = new ArrayList<String>();
		
		for(String number : numbers) {
			if(toInt(number) >= 0) {
				total += toInt(number);
			}
			else {
				negativeNumbers.add(number);
			}	
		}
		if(negativeNumbers.size() > 0) {
			throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
		}

		return total;
	}
}