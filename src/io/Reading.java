package io;

import helperObjects.Customer;
import helperObjects.Queue;
import helperObjects.SLLQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reading
{
    public static Queue<Customer> readFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Queue<Customer> inputQueue = new SLLQueue<>();

        if(file.exists()) {
            Scanner scanner = new Scanner(file);
            int counter = 0;
            while (scanner.hasNextLine()) {
               String s = scanner.nextLine();
               String[] params = s.split(",");
                int arrival = 0;
                //if(counter ==0) {
                //    arrival = Integer.parseInt(params[0].substring(1));
                //}
                //else
                //{
                    arrival = Integer.parseInt(params[0]);
                //}

                int id = Integer.parseInt(params[1]);
                int orderTime = Integer.parseInt(params[2]);
                double profit = Double.parseDouble(params[3].substring(1));
                int patience = Integer.parseInt(params[4]);
                Customer customer = new Customer(arrival, id, orderTime, profit, patience);
                inputQueue.enqueue(customer);
                //counter ++;
            }
        }

        return inputQueue;
    }
}
