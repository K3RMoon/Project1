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
        this.inputQueue = new SLLQueue<>();
        for(int i =0; i < inputQueue.size(); i++)
        {
            this.inputQueue.enqueue(inputQueue.first().clone());
            inputQueue.enqueue(inputQueue.dequeue());
        }
	}

	@Override
	public void run() 
	{
	    int counter = 0;
	    int orderCounter = 1;

		while(!inputQueue.isEmpty() || !processingStack.isEmpty())
        {
            counter++;
            orderCounter--;

            int currentLineSize = processingStack.size();
            Stack<Customer> tempStack = new LLStack<>();

            for(int i=0; i<currentLineSize; i++)
            {
                if(processingStack.top().getLineCounter() <= 0)
                {
                    processingStack.pop();
                    disCustomers++;
                }
                else
                {
                    processingStack.top().setLineCounter(processingStack.top().getLineCounter()-1);
                    tempStack.push(processingStack.pop());
                }


            }

            while(!tempStack.isEmpty())
            {
                processingStack.push(tempStack.pop());
            }

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

        }
        for(Customer c: servedCustomers)
            System.out.println(c.getOrderCost());

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

    public ArrayList<Customer> getCustomersServed() {
        return servedCustomers;
    }

    public void setServedCustomers(ArrayList<Customer> servedCustomers) {
        this.servedCustomers = servedCustomers;
    }

    public String toString()
    {
        Double profitt = profit;
        return "\nMat's Approach Profit: $" + profitt.floatValue() + "\nMat's approach number of dissapointed customers: " + disCustomers;
    }
}
