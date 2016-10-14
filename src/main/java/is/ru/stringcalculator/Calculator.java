package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("-"))
		{
			String error = "Negatives not allowed: -4";
			int i = text.indexOf('-');
			while(i >= 0) {
				if(text.lastIndexOf(text) == i + 1) {
					error.concat(text.substring(i, i + 1));	
				}
				else {
					error.concat(text.substring(i, i + 2));	
				}
				i = text.indexOf('-', i + 1);
			}
			throw new IllegalArgumentException(error);
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",|\n");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}