package is.ru.stringcalculator;

import java.util.ArrayList;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.startsWith("//")){
			return sum(splitByDelimeter(text));
		}
		else if(text.contains("-"))
		{
			String[] numbers = splitNumbers(text);
			ArrayList<Integer> negatives = new ArrayList<Integer>();
			String error = "Negatives not allowed: ";
			
			for(String number : numbers) {
				if(toInt(number) < 0) {
					negatives.add(toInt(number));
				}
			}

			String x = "";
			
			if(negatives.size() > 1) {

				for(int i = 0; i < negatives.size() - 1; i++) {
					x = negatives.get(i).toString();
					error = error + x + ",";
				}
			}
			x = negatives.get(negatives.size() - 1).toString();
			error = error + x;
			
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
		    int toBeAdded = toInt(number);
		    if(toBeAdded < 1001) {
		    	total += toBeAdded;	
		    }
		     
		}
		return total;
    }

    private static String[] splitByDelimeter(String text) {
    	String[] part = text.split("\n");
		String delimiter = part[0].substring(2);
		text = part[1];
	    return text.split(delimiter);
    }
}