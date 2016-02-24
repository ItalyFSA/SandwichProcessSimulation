import java.io.*;

class Manager extends Employee
{
	public Manager()
	{
		wage = 150;
		maxHoursWorked = 6;
		maxHoursPaid = 8;
	}

	// 1 manager for every 3 employees
	public int calcNumManagers(int numEmployees)
	{
		if (numEmployees % 30 != 0)
		{
			return ((numEmployees / 30) + 1);
		}
		else
		{
			return (numEmployees / 30);
		}
	}
	
	public int getSalary()
	{
		return wage * maxHoursPaid * 5 * 52;
	}
}
