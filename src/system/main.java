package system;

import approaches.*;
import helperObjects.Customer;
import helperObjects.Queue;
import helperObjects.SLLQueue;

public class main
{
    public static void main(String[] args)
    {
        Customer cust1 = new Customer(1,451263,16,82.47,43);
        Customer cust2 = new Customer(2,540909,21,39.98,43);
        Customer cust3 = new Customer(3,909028,23,38.11,33);
        Customer cust4 = new Customer(4,123654,11,23.38,3);
        Customer cust5 = new Customer(5,541739,11,2.77,63);
        Customer cust6 = new Customer(6,541739,21,78.80,53);
        Customer cust7 = new Customer(7,541739,18,1.80,13);
        Customer cust8 = new Customer(8,541739,11,54.25,33);
        Customer cust9 = new Customer(9,541739,11,20.25,23);
        Customer cust10 = new Customer(10,541739,21,8.75,83);

        Queue<Customer> inputQueue = new SLLQueue<>();

        inputQueue.enqueue(cust1);
        inputQueue.enqueue(cust2);
        inputQueue.enqueue(cust3);
        inputQueue.enqueue(cust4);
        inputQueue.enqueue(cust5);
        inputQueue.enqueue(cust6);
        inputQueue.enqueue(cust7);
        inputQueue.enqueue(cust8);
        inputQueue.enqueue(cust9);
        inputQueue.enqueue(cust10);

        Queue<Customer> inputQueue2 = new SLLQueue<>();
        Queue<Customer> inputQueue3 = new SLLQueue<>();
        Queue<Customer> inputQueue4 = new SLLQueue<>();

        for(int i = 0; i < inputQueue.size(); i++)
        {
            inputQueue2.enqueue(inputQueue.first());
            inputQueue3.enqueue(inputQueue.first());
            inputQueue4.enqueue(inputQueue.first());

            inputQueue.enqueue(inputQueue.dequeue());
        }

        PatApproach pat = new PatApproach(inputQueue);
        MatApproach mat = new MatApproach(inputQueue2);
        MaxApproach max = new MaxApproach(inputQueue3);
        PacApproach pac = new PacApproach(inputQueue4);
        pat.run();
        mat.run();
        max.run();
        pac.run();

        System.out.println(pat);
        System.out.println(mat);
        System.out.println(max);
        System.out.println(pac);


    }
}
