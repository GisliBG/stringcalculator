package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers() {
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testNewLine() {
    	assertEquals(5, Calculator.add("2\n3"));
    }

    @Test
    public void testNegativeNumber() {
    	IllegalArgumentException exception = null;
    	try {
        	Calculator.add("4,-1,6");
    	} catch (IllegalArgumentException e) {
        	exception = e;
    	}
	    assertEquals("Negatives not allowed: -1", exception.getMessage());
    }

    @Test
    public void testNegativeNumbers() {
    	IllegalArgumentException exception = null;
    	try {
        	Calculator.add("4,-1,6,-4,-2");
    	} catch (IllegalArgumentException e) {
        	exception = e;
    	}
	    assertEquals("Negatives not allowed: -1,-4,-2", exception.getMessage());
    }

    @Test
    public void testIfNumberIsBiggerThen1000() {
    	assertEquals(1001, Calculator.add("1000,3000,1,1001"));
    }

    @Test
    public void testChangingDelimeter() {
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }
}