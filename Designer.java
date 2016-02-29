class Designer extends Employee
{
	public Designer()
	{
		wage = 100;
		maxHoursWorked = 6;
		maxHoursPaid = 8;
		outsourced = false;
	}
	
	public double getIndredients()
	{
		return 5.1;
	}

	public void setOutsourced()
	{
		outsourced = true;
	}
}
