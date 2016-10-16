package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import java.util.List;
import java.util.ArrayList;


public class CalculatorTest {


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
	public void testMultibleNumbers() {
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testNewLine() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testNegativeNumbers() {
		thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage("Negatives not allowed: [-1]");
    	Calculator.add("-1,2");
	}

	@Test
	public void testMultipleNegativeNumbers() {
		thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage("Negatives not allowed: [-4, -5]");
    	Calculator.add("2,-4,3,-5");
	}

	@Test
	public void testIgnoreLargeNumbers() {
		assertEquals(2, Calculator.add("1001,2"));
	}
}