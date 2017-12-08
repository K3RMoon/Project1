package approaches;

import java.util.ArrayList;

import helperObjects.*;

public class MatApproach implements Approach 
{
	private float profit;
	private int disCustomers;
	private Queue<Customer> inputQueue;
	private Stack<Customer> processingStack;
	private ArrayList<Customer> servedCustomers;
	
	public MatApproach(Queue<Customer> inputQueue)
	{
		
	}

	@Override
	public void run() 
	{
		// TODO: Implement Mat

	}

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getDisCustomers() {
        return disCustomers;
    }

    public void setDisCustomers(int disCustomers) {
        this.disCustomers = disCustomers;
    }

    public Queue<Customer> getInputQueue() {
        return inputQueue;
    }

    public void setInputQueue(Queue<Customer> inputQueue) {
        this.inputQueue = inputQueue;
    }

    public Stack<Customer> getProcessingStack() {
        return processingStack;
    }

    public void setProcessingStack(Stack<Customer> processingStack) {
        this.processingStack = processingStack;
    }

    public ArrayList<Customer> getServedCustomers() {
        return servedCustomers;
    }

    public void setServedCustomers(ArrayList<Customer> servedCustomers) {
        this.servedCustomers = servedCustomers;
    }

    public String toString()
    {
        return "\nMat's Approach Profit: $" + profit + "\nMat's approach number of dissapointed customers: " + disCustomers;
    }
}
