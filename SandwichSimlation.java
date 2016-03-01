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

		// testing calculating total number of sandwiches without counting errors Local
		u.calcTotalSandwichesWoErrorLocalTest();

		// testing calculating total number of sandwiches with counting errors Local
		u.calcTotalSandwichesWithErrorLocalTest();

		// testing calculating total number of sandwiches without counting errors offshore
		u.calcTotalSandwichesWoErrorOffshoreTest();

		// testing calculating total number of sandwiches with counting errors offshore
		u.calcTotalSandwichesWithErrorOffshoreTest();

		// testing calculating salaries local
		u.calculateSalariesLocalTest();

		// testing calculating salaries off shore
		u.calculateSalariesOffshoreTest();

		// testing calculating number of teams per number of sandwiches
		u.calculateTeamTest();

		System.out.println("END OF TESTS");
	}
}
