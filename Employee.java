class Employee
{
	public int wage;
	public int maxHoursWorked;
	public int maxHoursPaid;

	public int getSalary()
	{
		return wage * maxHoursPaid * 5 * 52;
	}
}
