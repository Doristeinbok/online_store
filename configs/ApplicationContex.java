package online_store.configs;


import online_store.enteties.Customer;


public class ApplicationContex {
	
	private static ApplicationContex instance;
	
	private Customer loggedInCustomer;
	
	static {
		instance = new ApplicationContex();
	}
	
	public static ApplicationContex getInstance() {
		return instance;
	}
	
	public void setLoggedInCustomer(Customer customer) {
		loggedInCustomer = customer;
	}
	
	public Customer getLoggedInCustomer() {
		return loggedInCustomer;
	}
	
	
}
