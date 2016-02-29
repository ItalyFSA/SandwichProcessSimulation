class Implementer extends Employee
{

	public Implementer()
	{
		wage = 125;
		maxHoursWorked = 6;
		maxHoursPaid = 8;
	}

	private double stack()
	{
		return 3;
	}

	private double combineSlices()
	{
		return 1.76;
	}

	private double cutSandwich()
	{
		return  3;
	}

	public double makeSandwich()
	{
		return (stack() + combineSlices() + cutSandwich());
	}

	public int getSalary()
	{
		return wage * maxHoursPaid * 5 * 52;
	}
}
