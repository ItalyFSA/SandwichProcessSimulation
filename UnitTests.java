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
		{
			System.out.println("Correct population of number of sandwiches to make.");
		}
		else
		{
			System.out.println("ERROR:: Incorrect population of number of sandwiches to make.");
		}

		// test filling of percentages
		if (s._percents.contains(1.00) && s._percents.contains(0.75) && s._percents.contains(0.25))
		{
			System.out.println("Correct percentages.");
		}
		else
		{
			System.out.println("ERROR:: Incorrect percentages.");
		}

		// test filling of budget
		if (s._budget == 1000000)
		{
			System.out.println("Correct budget.");
		}
		else
		{
			System.out.println("ERROR:: Incorrect budget.");
		}
	}

	public void calcTotalSandwichesWoErrorTest()
	{
		// test calculate num sandwiches without error
		int numSandwiches = s.calcTotalSandwichesWoError();
		if (numSandwiches == 750000)
		{
			System.out.println("Correct number of sandwiches calculated for WITHOUT error simulation.");
		}
		else
		{
			System.out.println("ERROR:: Incorrect number of sandwiches calculated for WITHOUT error simulation.");
		}
	}

	public void calcTotalSandwichesWithErrorTest()
	{
		// test calculate num sandwiches with error
		int numSandwiches = s.calcTotalSandwichesWithError();
		if (numSandwiches == 825000)
		{
			System.out.println("Correct number of sandwiches calculated for WITH error simulation.");
		}
		else
		{
			System.out.println("ERROR:: Incorrect number of sandwiches calculated for WITH error simulation.");
		}
	}

	public void calculateSalariesTest()
	{
		// testing over head for 1 team
		int overhead = s.calculateSalaries(1);
		if (overhead == 936000)
		{
			System.out.println("Correct overhead cost for 1 team.");
		}
		else
		{
			System.out.println("ERROR:: Incorrect overhead cost for 1 team.");
		}
	}

}
