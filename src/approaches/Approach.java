package approaches;


import helperObjects.Customer;
import helperObjects.Queue;

import java.util.ArrayList;

public interface Approach
{
	public void run();
	public double getProfit();
	public int getDisCustomers();
	public Queue<Customer> getInputQueue();
	public ArrayList<Customer> getCustomersServed();
}
