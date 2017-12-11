package approaches;

import java.util.ArrayList;
import helperObjects.Queue;

import helperObjects.Customer;
import helperObjects.SLLQueue;

public class PatApproach implements Approach 
{
	private double profit;
	private int disCustomers;
	private Queue<Customer> inputQueue;
	private Queue<Customer> processingQueue;
	private ArrayList<Customer> customersServed;
	
	public PatApproach(Queue<Customer> inputQueue)
	{
		profit = 0;
		disCustomers=0;
		processingQueue = new SLLQueue<Customer>();
		customersServed = new ArrayList<Customer>();
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

		while(!inputQueue.isEmpty()||!processingQueue.isEmpty())
        {
            counter++;
            orderCounter--;

            int currentLineSize = processingQueue.size();

            for(int i = 0; i < currentLineSize; i++)
            {
                processingQueue.first().setLineCounter(processingQueue.first().getLineCounter()-1);
                if(processingQueue.first().getLineCounter() <= 0)
                {
                    processingQueue.dequeue();
                    disCustomers++;
                }
                else
                {
                    processingQueue.enqueue(processingQueue.dequeue());
                }
            }

            while(!inputQueue.isEmpty()&&inputQueue.first().getMomentOfArrival()==counter)
            {
                processingQueue.enqueue(inputQueue.dequeue());
            }


			if(!processingQueue.isEmpty() && orderCounter <= 0)
			{
				orderCounter = processingQueue.first().getOrderTime();
				profit = profit + processingQueue.first().getOrderCost();
				customersServed.add(processingQueue.dequeue());
			}


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

	public Queue<Customer> getProcessingQueue() {
		return processingQueue;
	}

	public void setProcessingQueue(Queue<Customer> processingQueue) {
		this.processingQueue = processingQueue;
	}

	public ArrayList<Customer> getCustomersServed() {
		return customersServed;
	}

	public void setCustomersServed(ArrayList<Customer> customersServed) {
		this.customersServed = customersServed;
	}
	
	public String toString()
	{
		Double profitt = profit;
		return "\nPat's Approach Profit: $" + profitt.floatValue() + "\nPat's approach number of dissapointed customers: " + disCustomers;
	}
}
