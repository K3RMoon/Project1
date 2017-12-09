package helperObjects;

import java.util.Comparator;

//For Order Time
public class CustomerComparator1<Customer> implements Comparator<helperObjects.Customer>
{

    public int compare(helperObjects.Customer customer1, helperObjects.Customer customer2)
    {
        if(customer1.getOrderTime()>customer2.getOrderTime())
        {
            return 1;
        }
        else
        {
            if(customer1.getOrderTime() == (customer2.getOrderTime()))
                return 0;
        }

        return -1;
    }


}
