package approaches;

import helperObjects.*;
import java.util.ArrayList;

public class MaxApproach implements Approach
{
    private float profit;
    private int disCustomers;
    private Queue<Customer> inputQueue;
    private ArrayList<Customer> customersServed;
    private PriorityQueue<Integer, Customer> processingPQ;

    public MaxApproach(Queue<Customer> inputQueue)
    {
        profit = 0;
        disCustomers = 0;
        customersServed = new ArrayList<Customer>();
        processingPQ = new SortedListPriorityQueue<Integer,Customer>();
        this.inputQueue = inputQueue;
    }

    public void run()
    {
        //TODO:  Implement
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

    public ArrayList<Customer> getCustomersServed() {
        return customersServed;
    }

    public void setCustomersServed(ArrayList<Customer> customersServed) {
        this.customersServed = customersServed;
    }

    public PriorityQueue<Integer, Customer> getProcessingPQ() {
        return processingPQ;
    }

    public void setProcessingPQ(PriorityQueue<Integer, Customer> processingPQ) {
        this.processingPQ = processingPQ;
    }

    public String toString()
    {
        return  "\nMax's Approach Profit: $" + profit + "\nMax's approach number of dissapointed customers: " + disCustomers;
    }
}