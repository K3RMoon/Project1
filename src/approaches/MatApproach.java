package approaches;

import java.util.ArrayList;

import helperObjects.*;

public class MatApproach implements Approach 
{
	private double profit;
	private int disCustomers;
	private Queue<Customer> inputQueue;
	private Stack<Customer> processingStack;
	private ArrayList<Customer> servedCustomers;
	
	public MatApproach(Queue<Customer> inputQueue)
	{
		profit = 0;
		disCustomers = 0;
		processingStack = new LLStack<>();
		servedCustomers = new ArrayList<>();
		this.inputQueue = inputQueue;
	}

	@Override
	public void run() 
	{
	    int counter = 1;
	    int orderCounter = 0;

		while(!inputQueue.isEmpty() || !processingStack.isEmpty())
        {
            while(!inputQueue.isEmpty() && inputQueue.first().getMomentOfArrival() == counter)
            {
                processingStack.push(inputQueue.dequeue());
            }

            if(!processingStack.isEmpty() && orderCounter <= 0)
            {
                orderCounter = processingStack.top().getOrderTime();
                profit += processingStack.top().getOrderCost();
                servedCustomers.add(processingStack.pop());
            }

            int currentLineSize = processingStack.size();
            Stack<Customer> tempStack = new LLStack<>();

            for(int i=0; i<currentLineSize; i++)
            {
                processingStack.top().setLineCounter(processingStack.top().getLineCounter()-1);
                if(processingStack.top().getLineCounter() <= 0)
                {
                    processingStack.pop();
                    disCustomers++;
                }
                else
                {
                    tempStack.push(processingStack.pop());
                }
            }

            while(!tempStack.isEmpty())
            {
                processingStack.push(tempStack.pop());
            }


            counter++;
            orderCounter--;
        }

	}

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
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
