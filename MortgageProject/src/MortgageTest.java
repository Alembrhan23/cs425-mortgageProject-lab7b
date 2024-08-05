import static org.junit.Assert.*;

import org.junit.Test;

public class MortgageTest {

	private MortgageCalculator mortgageCalculator;

	@Before
	public void setUp() {
		mortgageCalculator = new MortgageCalculator();
	}

	@Test
	public void testArchitectWith3000MonthlyIncome() {
		double result = mortgageCalculator.computeMaxMortgage(1967, 5, 2, 3000, false, 0, "Architect");
		assertEquals(180000, result, 0.001);
	}

	@Test
	public void testArchitectWith3000MonthlyIncomeAndTooYoung() {
		double result = mortgageCalculator.computeMaxMortgage(2001, 5, 2, 3000, false, 0, "Architect");
		assertEquals(0, result, 0.001);
	}

	@Test
	public void testDeveloperWith4000MonthlyIncomeAndPartner() {
		double result = mortgageCalculator.computeMaxMortgage(1977, 12, 2, 4000, true, 2000, "Developer");
		assertEquals(220000, result, 0.001);
	}

	@Test
	public void testProfessorWith5500MonthlyIncome() {
		double result = mortgageCalculator.computeMaxMortgage(1954, 5, 12, 5500, false, 0, "Professor");
		assertEquals(280000, result, 0.001);
	}

	@Test
	public void testYoungTesterWithLowIncome() {
		double result = mortgageCalculator.computeMaxMortgage(2003, 4, 10, 1500, false, 0, "Tester");
		assertEquals(0, result, 0.001);
	}

	@Test
	public void testDepartmentHeadWithHighIncome() {
		double result = mortgageCalculator.computeMaxMortgage(1970, 3, 14, 6000, false, 0, "Department head");
		assertEquals(280000, result, 0.001);
	}
}

}
