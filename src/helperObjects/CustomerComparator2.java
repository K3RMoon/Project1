package helperObjects;

import java.util.Comparator;

//For Order Time
public class CustomerComparator2<Customer> implements Comparator<helperObjects.Customer>
{

    public int compare(helperObjects.Customer customer1, helperObjects.Customer customer2)
    {
        if(customer1.getOrderCost()>customer2.getOrderCost())
        {
            return -1;
        }
        else
        {
            if(customer1.getOrderCost() == (customer2.getOrderCost()))
                return 0;
        }

        return 1;
    }


}
