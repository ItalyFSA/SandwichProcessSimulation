class Implementer extends Employee
{

	public Implementer()
	{
		wage = 125;
		maxHoursWorked = 6;
		maxHoursPaid = 8;
	}

	private double spreadPeanutButter()
	{
		return 17.8;
	}

	private double combineSlices()
	{
		return 1.76;
	}

	private double cutSandwich()
	{
		return  7.9;
	}

	public double makeSandwich()
	{
		return ((spreadPeanutButter() * 2) + combineSlices() + cutSandwich());
	}

	public int getSalary()
	{
		return wage * maxHoursPaid * 5 * 52;
	}
}
