package system;

import approaches.*;
import helperObjects.Customer;
import helperObjects.Queue;
import helperObjects.SLLQueue;
import io.Printing;
import io.Reading;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class main
{
    public static void main(String[] args)
    {
        Queue<Customer> inputQueue = new SLLQueue<>();
        try {
            inputQueue = Reading.readFromFile("input7.csv");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("ERROR READING FILE");
        }
        catch(Exception e)
        {
            System.out.println("ERROR");
        }

        Approach pat = new PatApproach(inputQueue);
        Approach mat = new MatApproach(inputQueue);
        Approach max = new MaxApproach(inputQueue);
        Approach pac = new PacApproach(inputQueue);

        pat.run();
        mat.run();
        pac.run();
        max.run();

        ArrayList<String> toPrint = new ArrayList<>();
        double maxProfit = 0;
        for(int i =0; i <inputQueue.size(); i++)
        {
            maxProfit+=inputQueue.first().getOrderCost();
            inputQueue.enqueue(inputQueue.dequeue());
        }

        Double profit = maxProfit;
        toPrint.add("Maximum profit possible: " + profit.floatValue());
        toPrint.add("Maximum number of customers served possible: " + inputQueue.size());
        toPrint.add(pat + "");
        toPrint.add(mat + "");
        toPrint.add(max + "");
        toPrint.add(pac + "");

        Printing.printOnScreen(toPrint);


    }
}
