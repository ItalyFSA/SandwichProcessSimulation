import java.io.*;
import java.util.*;

class Simulation
{
	public int _budget;
	public ArrayList<Double> _totalSandwiches;
	public ArrayList<Double> _percents;

	public Simulation()
	{

	}
	
	public void getInfo()
	{
		BufferedReader br = null;

		try
		{
			_totalSandwiches = new ArrayList<Double>();
			_percents = new ArrayList<Double>();
			br = new BufferedReader(new FileReader("app.config"));
			String currentLine;

			while ((currentLine = br.readLine()) != null) 
			{
				//System.out.println("Current Line: " + currentLine);
				String[] splitLine = currentLine.split(" ");

				if (splitLine.length == 0)
				{
					// if there isnt a | break
					break;
				}
				else if (splitLine[0].equals("budget"))
				{
					// if its beginning is budget then it is the budget
					_budget = Integer.parseInt(splitLine[1]);
					System.out.println("Budget: " + _budget);
				}
				else
				{
					// otherwise the beginning is num sandwiches and percent of those that will be made
					_totalSandwiches.add(Double.parseDouble(splitLine[0]));
					_percents.add(Double.parseDouble(splitLine[1]));
					System.out.println("Order " + Double.parseDouble(splitLine[0]) + " " + Double.parseDouble(splitLine[1]));
					/*System.out.println("Order\n[0]: " + splitLine[0]);
					System.out.println("[0] Parsed Double: " + Double.parseDouble(splitLine[0]));
					System.out.println("[1]: " + splitLine[1]);
					System.out.println("[1] Parsed Double: " + Double.parseDouble(splitLine[1]));*/
				}
			}
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (br != null)
          			br.close();
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}

	public int calcTotalSandwichesWoError()
	{
		int total = 0;
		for (int i = 0; i < _totalSandwiches.size(); ++i)
		{
		    Double numSandwiches = _totalSandwiches.get(i);
		    Double percentageMade = _percents.get(i);
		    // add to total percentage of sandwiches made 
		    System.out.println("Sandwiches " + numSandwiches + " Percent " + percentageMade);
			total += (numSandwiches * percentageMade);
		}
		return total;
	}

	public int calcTotalSandwichesWithError()
	{
		int total = 0;
		for (int i = 0; i < _totalSandwiches.size(); ++i)
		{
		    Double numSandwiches = _totalSandwiches.get(i);
		    Double percentageMade = _percents.get(i);
		    // add to total percentage of sandwiches made 
		    System.out.println("Sandwiches " + numSandwiches + " Percent " + percentageMade);
			total += (numSandwiches * percentageMade);
		}
		// accounting for 10 percent error
		total += (total * .1);
		return total;
	}
	
	public double makeSandwiches(int numTeams, int totalSandwiches)
	{
		double totalTimeSeconds = 0.0;

		// designer gets ingredients and adds that time to total time
		Designer d = new Designer();
		totalTimeSeconds += d.getIndredients();

		// implementer makes sandwich and adds that time to total time
		Implementer i = new Implementer();
		totalTimeSeconds += i.makeSandwich();

		// tester eats sandwich and adds that time to total time
		Tester t = new Tester();
		totalTimeSeconds += t.eatSandwich();
		System.out.println("Total time to make a sandwich in seconds: " + totalTimeSeconds);

		// take time that it takes to go through process once and multiply by total number of sandwiches
		totalTimeSeconds *= totalSandwiches;
		System.out.println("Total time to make all sandwiches in seconds: " + totalTimeSeconds);

		// they only work 30 hours a week 
		double totalTimeYears = totalTimeSeconds / (30.0 * 60.0 * 60.0 * 52.0 * numTeams);
		System.out.println("Total time to make all sandwiches in years: " + totalTimeYears);

		return totalTimeYears;
	}

	public int calculateSalaries(int numTeams)
	{
		Designer d = new Designer();
		int designerSalary = d.getSalary();
		System.out.println("Designer Salary: " + designerSalary);

		Implementer i = new Implementer();
		int implementerSalary = i.getSalary();
		System.out.println("Implementer Salary: " + implementerSalary);

		Tester t = new Tester();
		int testerSalary = t.getSalary();
		System.out.println("Tester Salary: " + testerSalary);

		Manager m = new Manager();
		int numManagers = m.calcNumManagers(numTeams * 3);
		System.out.println("Number Managers: " + numManagers);
		int managerSalary = m.getSalary();
		System.out.println("Manager Salary: " + managerSalary);

		int totalOverhead = (managerSalary * numManagers) + (designerSalary * numTeams) + 
			(implementerSalary * numTeams) + (testerSalary * numTeams);

		return totalOverhead;
	}

	public void runPerfect()
	{
		System.out.println("\n\nRunning Perfect Simulation\n");
		// read in config file
		getInfo();

		// get total sandwiches needed without error
		int totalNumSandwichesNeeded = calcTotalSandwichesWoError();
		System.out.println("Total Sandwiches Needed: " + totalNumSandwichesNeeded);

		// start with one team
		int numTeams = 1;

		boolean simulationRunning = true;
		while (simulationRunning)
		{
			// see how long it takes to make the sandwiches 
			double totalTime = makeSandwiches(numTeams,totalNumSandwichesNeeded);
			if (totalTime < 1.0)
			{
				// if they made all of them within the year done with simulation
				simulationRunning = false;
			}
			else
			{
				// otherwise increase the number of people
				numTeams++;
				System.out.println("Number of teams: " + numTeams);
			}
		}
		// found optimal teams for making all sandwiches
		System.out.println("Optimal number of teams: " + numTeams);

		// print info to a file output info
		int overhead = calculateSalaries(numTeams);
		System.out.println("Overhead: " + overhead);
	}

	public void runError()
	{
		System.out.println("\n\nRunning Error Simulation\n");
		// read in config file
		getInfo();

		// get total sandwiches needed with error
		int totalNumSandwichesNeeded = calcTotalSandwichesWithError();
		System.out.println("Total Sandwiches Needed: " + totalNumSandwichesNeeded);

		// start with one team
		int numTeams = 1;

		boolean simulationRunning = true;
		while (simulationRunning)
		{
			// see how long it takes to make the sandwiches 
			double totalTime = makeSandwiches(numTeams,totalNumSandwichesNeeded);
			if (totalTime < 1.0)
			{
				// if they made all of them within the year done with simulation
				simulationRunning = false;
			}
			else
			{
				// otherwise increase the number of people
				numTeams++;
				System.out.println("Number of teams: " + numTeams);
			}
		}
		// found optimal teams for making all sandwiches
		System.out.println("Optimal number of teams: " + numTeams);

		// print info to a file output info
		int overhead = calculateSalaries(numTeams);
		System.out.println("Overhead: " + overhead);
	}
}

