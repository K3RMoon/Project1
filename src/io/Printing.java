package io;

import java.util.ArrayList;

public class Printing
{
    public static void printOnScreen(ArrayList<String> toPrint)
    {
        for(String s : toPrint)
        {
            System.out.println(s);
        }
    }
}
