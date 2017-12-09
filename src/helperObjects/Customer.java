package helperObjects;

public class Customer
{
	private int momentOfArrival;
	private int customerID;
	private int orderTime;
	private double orderCost;
	private int patienceLevel;
	private int lineCounter;
	
	public Customer(int momentOfArrival, int customerID, int orderTime, double orderCost, int patienceLevel)
	{
		this.momentOfArrival=momentOfArrival;
		this.customerID=customerID;
		this.orderTime=orderTime;
		this.orderCost=orderCost;
		this.patienceLevel=patienceLevel;
		this.lineCounter=patienceLevel;
	}

	public int getMomentOfArrival() {
		return momentOfArrival;
	}

	public void setMomentOfArrival(int momentOfArrival) {
		this.momentOfArrival = momentOfArrival;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public double getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}

	public int getPatienceLevel() {
		return patienceLevel;
	}

	public void setPatienceLevel(int patienceLevel) {
		this.patienceLevel = patienceLevel;
	}

	public int getLineCounter() {
		return lineCounter;
	}

	public void setLineCounter(int lineCounter) {
		this.lineCounter = lineCounter;
	}

	
}
