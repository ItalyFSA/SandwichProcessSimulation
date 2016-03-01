import java.io.*;
import java.util.*;

class UnitTests
{
	private Simulation s;

	public UnitTests()
	{
		s = new Simulation();
	}
	
	public void getInfoTest()
	{
		s.getInfo();

		// test filling of num of sandwiches
		if (s._totalSandwiches.contains(500000.0) && s._totalSandwiches.contains(250000.0))
			System.out.println("Correct population of number of sandwiches to make.");
		else
			System.out.println("ERROR:: Incorrect population of number of sandwiches to make.");

		// test filling of percentages
		if (s._percents.contains(1.00) && s._percents.contains(0.75) && s._percents.contains(0.25))
			System.out.println("Correct percentages.");
		else
			System.out.println("ERROR:: Incorrect percentages.");

		// test filling of budget
		if (s._budget == 1000000)
			System.out.println("Correct budget.");
		else
			System.out.println("ERROR:: Incorrect budget.");
	}

	public void calcTotalSandwichesWoErrorLocalTest()
	{
		// test calculate num sandwiches without error
		int numSandwiches = s.calcTotalSandwichesLocal(false);

		if (numSandwiches == 500000)
			System.out.println("Correct number of sandwiches calculated for WITHOUT error simulation.");
		else
			System.out.println("ERROR:: Incorrect number of sandwiches calculated for WITHOUT error simulation.");
	}

	public void calcTotalSandwichesWithErrorLocalTest()
	{
		// test calculate num sandwiches with error
		int numSandwiches = s.calcTotalSandwichesLocal(true);

		if (numSandwiches == 550000)
			System.out.println("Correct number of sandwiches calculated for WITH error simulation.");
		else
			System.out.println("ERROR:: Incorrect number of sandwiches calculated for WITH error simulation.");
	}

	public void calcTotalSandwichesWoErrorOffshoreTest()
	{
		// test calculate num sandwiches without error
		int numSandwiches = s.calcTotalSandwichesOffshore(false);

		if (numSandwiches == 250000)
			System.out.println("Correct number of sandwiches calculated for WITHOUT error simulation.");
		else
			System.out.println("ERROR:: Incorrect number of sandwiches calculated for WITHOUT error simulation.");
	}

	public void calcTotalSandwichesWithErrorOffshoreTest()
	{
		// test calculate num sandwiches with error
		int numSandwiches = s.calcTotalSandwichesOffshore(true);

		if (numSandwiches == 325000)
			System.out.println("Correct number of sandwiches calculated for WITH error simulation.");
		else
			System.out.println("ERROR:: Incorrect number of sandwiches calculated for WITH error simulation.");
	}

	public void calculateSalariesLocalTest()
	{
		// testing over head for 1 team
		double overhead = s.calculateSalaries(1, false);
		if (overhead == 936000.0)
			System.out.println("Correct local overhead cost for 1 team.");
		else
			System.out.println("ERROR:: Incorrect local overhead cost for 1 team.");
	}

	public void calculateSalariesOffshoreTest()
	{
		// testing over head for 1 team
		double overhead = s.calculateSalaries(1, true);
		if (overhead == 234000.0)
			System.out.println("Correct offshore overhead cost for 1 team.");
		else
			System.out.println("ERROR:: Incorrect offshore overhead cost for 1 team.");
	}

	public void calculateTeamTest()
	{
		// testing creation of teams
		double numTeams = s.calculateTeamNumber(1000000);
		if (numTeams == 10.0)
			System.out.println("Correct creation of teams.");
		else
			System.out.println("ERROR:: Incorrect creation of teams.");
	}
}
