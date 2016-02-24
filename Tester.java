class Tester extends Employee
{
	public Tester()
	{
		wage = 75;
		maxHoursWorked = 6;
		maxHoursPaid = 8;
	}

	public double eatSandwich()
	{
		// time taken up is 165.6 seconds
		return 165.6;
	}

	public int getSalary()
	{
		return wage * maxHoursPaid * 5 * 52;
	}
}
