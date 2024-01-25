package Bank;

/*
 * This class is responsible for the logic of the bank system.
 */

public class Account 
{
	
	private double balance;

	// Constructor
	
	public Account(double balance)
	{
		this.balance = balance;
	}

	// Getters and setters

	public double getBalance()
	{
		return this.balance;
	}

	// Public methods

	public void deposit(double amount)
	{
		this.balance += amount;
	}

	public boolean withdraw(double amount)
	{	
		if (amount > this.balance)
			return false;
		
		this.balance -= amount;
		return true;
	}

}
