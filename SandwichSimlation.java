import java.io.*;
import java.util.*;

class SandwichSimlation
{
	public static void main(String[] args)
	{
		try
		{
			// tests
			runTests();

			Simulation sim = new Simulation();

			// calling function that runs simulation
			sim.runPerfect();
			sim.runError();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static void runTests()
	{
		UnitTests u = new UnitTests();

		// testing getting info from file
		u.getInfoTest();

		// testing calculating total number of sandwiches without counting errors
		u.calcTotalSandwichesWoErrorTest();

		// testing calculating total number of sandwiches with counting errors
		u.calcTotalSandwichesWithErrorTest();

		// testing calculating salaries
		u.calculateSalariesTest();
	}
}
