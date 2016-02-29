class Tester extends Employee
{
	public Tester()
	{
		wage = 75;
		maxHoursWorked = 6;
		maxHoursPaid = 8;
		outsourced = false;
	}

	public double eatSandwich()
	{
		// time taken up is 41.4 seconds
		// cut time down to 1/4 of the original time
		return 41.4;
	}

	public int getSalary()
	{
		return wage * maxHoursPaid * 5 * 52;
	}

	public void setOutsourced()
	{
		outsourced = true;
	}
}
