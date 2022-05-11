package online_store.configs;


import online_store.enteties.Customer;


public class ApplicationContex {
	
	private static ApplicationContex instance;
	
	private Customer loggedInCustomer;
	
	public static ApplicationContex getInstance() {
		if(null == instance) {
			instance = new ApplicationContex();
		}
		
		return instance;
	}
	
	public void setLoggedInCustomer(Customer customer) {
		loggedInCustomer = customer;
	}
	
	public Customer getLoggedInCustomer() {
		return loggedInCustomer;
	}
	
	
}
