import java.time.LocalDate;
import java.time.Period;

public class MortgageCalculator {

	private static final List<String> HIGH_MORTGAGE_PROFESSIONS = Arrays.asList("Developer", "Architect", "Scrum master");
	private static final List<String> MEDIUM_MORTGAGE_PROFESSIONS = Arrays.asList("Tester", "System Administrator", "Technical writer");
	private static final List<String> VERY_HIGH_MORTGAGE_PROFESSIONS = Arrays.asList("Department head", "Professor");

	public double computeMaxMortgage(int yearOfBirth, int month, int day, double monthlyIncome, boolean married, double monthlyIncomePartner, String profession) {
		int age = calculateAge(yearOfBirth, month, day);

		if (age < 18) {
			return 0;
		}

		double totalIncome = married ? calculateTotalIncome(monthlyIncome, monthlyIncomePartner) : monthlyIncome;

		if (totalIncome < 2000) {
			return 0;
		}

		if (totalIncome < 3000) {
			return getMortgageAmount(profession, 160000, 120000, 220000);
		} else if (totalIncome < 5000) {
			return getMortgageAmount(profession, 180000, 140000, 250000);
		} else {
			return getMortgageAmount(profession, 220000, 160000, 280000);
		}
	}

	private int calculateAge(int yearOfBirth, int month, int day) {
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(yearOfBirth, month, day);
		Period period = Period.between(birthday, today);
		return period.getYears();
	}

	private double calculateTotalIncome(double monthlyIncome, double monthlyIncomePartner) {
		return monthlyIncome + monthlyIncomePartner * 0.94;
	}

	private double getMortgageAmount(String profession, double highAmount, double mediumAmount, double veryHighAmount) {
		if (HIGH_MORTGAGE_PROFESSIONS.contains(profession)) {
			return highAmount;
		} else if (MEDIUM_MORTGAGE_PROFESSIONS.contains(profession)) {
			return mediumAmount;
		} else if (VERY_HIGH_MORTGAGE_PROFESSIONS.contains(profession)) {
			return veryHighAmount;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		MortgageCalculator calculator = new MortgageCalculator();
		System.out.println("Maximum Mortgage: " + calculator.computeMaxMortgage(1985, 5, 15, 4000, false, 0, "Developer"));
		System.out.println("Maximum Mortgage: " + calculator.computeMaxMortgage(1990, 12, 10, 2500, true, 2000, "Tester"));
	}
}
}
