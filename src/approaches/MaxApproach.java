package approaches;

import helperObjects.*;
import java.util.ArrayList;

public class MaxApproach implements Approach
{
    private double profit;
    private int disCustomers;
    private Queue<Customer> inputQueue;
    private ArrayList<Customer> customersServed;
    private PriorityQueue<Customer, Integer> processingPQ;

    //MAX PROFIT
    public MaxApproach(Queue<Customer> inputQueue)
    {
        profit = 0;
        disCustomers = 0;
        customersServed = new ArrayList<Customer>();
        processingPQ = new SortedListPriorityQueue<Customer,Integer>(new CustomerComparator2<Customer>());
        this.inputQueue = new SLLQueue<>();
        for(int i =0; i < inputQueue.size(); i++)
        {
            this.inputQueue.enqueue(inputQueue.first().clone());
            inputQueue.enqueue(inputQueue.dequeue());
        }
    }

    public void run()
    {
        int counter = 0;
        int orderCounter = 1;

        while(!inputQueue.isEmpty()||!processingPQ.isEmpty()) {

            counter++;
            orderCounter--;

            int currentLineSize = processingPQ.size();
            ArrayList<Entry<Customer, Integer>> tempList = new ArrayList<>();

            for (int i = 0; i < currentLineSize; i++) {
                processingPQ.min().getKey().setLineCounter(processingPQ.min().getKey().getLineCounter() - 1);
                if (processingPQ.min().getKey().getLineCounter() <= 0) {
                    processingPQ.removeMin();
                    disCustomers++;
                }
                else {
                    tempList.add(processingPQ.removeMin());
                }
            }
            for (Entry<Customer, Integer> entry : tempList) {
                processingPQ.insert(entry.getKey(), entry.getValue());
            }

            while(!inputQueue.isEmpty() && inputQueue.first().getMomentOfArrival() == counter)
            {
                processingPQ.insert(inputQueue.dequeue(), counter);
            }

            if (!processingPQ.isEmpty() && orderCounter <= 0) {
                orderCounter = processingPQ.min().getKey().getOrderTime();
                profit += processingPQ.min().getKey().getOrderCost();
                customersServed.add(processingPQ.removeMin().getKey());
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

    public ArrayList<Customer> getCustomersServed() {
        return customersServed;
    }

    public void setCustomersServed(ArrayList<Customer> customersServed) {
        this.customersServed = customersServed;
    }

    public PriorityQueue<Customer, Integer> getProcessingPQ() {
        return processingPQ;
    }

    public void setProcessingPQ(PriorityQueue<Customer, Integer> processingPQ) {
        this.processingPQ = processingPQ;
    }

    public String toString()
    {
        Double profitt = profit;

        return  "\nMax's Approach Profit: $" + profitt.floatValue() + "\nMax's approach number of dissapointed customers: " + disCustomers;
    }
}