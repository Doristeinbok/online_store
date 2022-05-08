package online_store;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static List<Customer> customers = new ArrayList<>();
	private static int DEFAULT_INITIAL_USERS = 10;
	private static int lastUserIndex = 0; 
	private static Customer currentCustomer = null; 
	
	static {
		customers.add(new Customer(0, "dori", 1234));
		customers.add(new Customer(1, "gili", 1234));
		customers.add(new Customer(2, "lior", 1234));
		customers.add(new Customer(3, "beeri", 1234));
		lastUserIndex = 4;
	}
	
	public static void main(String[] args) {
		int number;
		String name = "";
		String answer = "";
		int password;	
		String[] itemsToCatalog= {"computer", "mouse", "keyboard", "cable", "phone",
							"desk", "chair", "book", "air conditioner", "pen"};
		Catalog catalog = new Catalog(itemsToCatalog);

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("************ General form ************");
			System.out.print("1. Sign up\t\t");
			System.out.println("4. My Orders");
			if(currentCustomer == null) {
				System.out.print("2. Sign in\t\t");
			}else {
				System.out.print("2. Sign out\t\t");
			}
			System.out.println("5. Settings");
			System.out.print("3. Product Catalog\t");
			System.out.println("6. Customer List");
			System.out.println("**************************************");
			System.out.println("Please enter number to cuntinue");
			
			if(sc.hasNextInt()) {
				number = sc.nextInt();
			} else {
				System.out.println("Please enter legit number to cuntinue");
				sc.nextLine();
				continue;
			}
			
			switch(number) {
				case 1: //Sign up
					if(lastUserIndex >= DEFAULT_INITIAL_USERS) {
						System.out.println("sorry, the list is full");
						continue;
					}
					
					System.out.println("Please insert your name");
					name = sc.next(); 
					System.out.println("Please insert password");
					password = sc.nextInt();
					
					customers.add(new Customer(lastUserIndex, name, password));	
//					lastUserIndex++;
					currentCustomer = customers.get(customers.size() - 1);
					break;
					
				case 2: //sign in or sign out
					if(currentCustomer != null) {
						currentCustomer = null;
						System.out.println("You just signed out!");
						break;
					}
					if(lastUserIndex == 0) {
						System.out.println("You can't sign in, because there are 0 customers registered");
						continue;
					}
					
					if(currentCustomer != null) {
						System.out.println(currentCustomer.getName() + "is already signed in");
						continue;
					}
					
					System.out.println("what is your name?");
					name = sc.next();
					
					for(Customer customer : customers) {
						if(customer == null) {
							System.out.println("empty array");
							break;
						}
						if (customer.getName().equals(name)) {
							System.out.println("Insert password");
							password = sc.nextInt();
							if(customer.getPassword() == password) {
								System.out.println("Welcome back, " + name);
								currentCustomer = customer;
								break;
							} else {
								System.out.println("Wrong id, " + name);
								break;
							}
						}
					}
					
					break;
					
				case 3: //product catalog
					if(currentCustomer == null) {
						System.out.println("You need to sign in for purchasing");
						break;
					}
					
					do {
						System.out.println("********** Catalog **********");
						for(Product product : catalog.getProducts()) {
							System.out.println(product.getName() + "  (id:" + product.getId() + ")");
						}
						System.out.println("********** End of Catalog **********");
						
						System.out.println("Please enter product id to add to cart");
						int itemId = sc.nextInt();
						
						Cart cart = currentCustomer.getCart();
						
						Product productToAdd = catalog.getProductById(itemId);
						
						cart.addProduct(productToAdd);
						System.out.println(productToAdd.getName() + " was added to cart");
						
						System.out.println("do you want to continue shopping? (y/n)");
						answer = sc.next().toLowerCase();
						
					}while(answer.equalsIgnoreCase("y"));
					
					System.out.println("Hope you enjoyed shopping!");
					break;
					
				case 4: //My orders
					if(currentCustomer == null) {
						System.out.println("Please sign in first");
						break;
					}
					
					Cart currentCart = currentCustomer.getCart();
					if(currentCart.getProducts().isEmpty()) {
						System.out.println("your cart is empty");
						break;
					}
					
					System.out.println(currentCart.getName() +  " list:");
					for(Product product : currentCart.getProducts()) {
						if(product != null) {
							System.out.println(product.toString());
						}
					}
					
					
					break;
					
					
				case 6: //Customer List
					if(currentCustomer != null) {
						System.out.println("You are viewing this list as " + currentCustomer.getName());
					}
					
					System.out.println("Customer List:");
					for(Customer customer : customers) {
						if(null == customer) {
							break;
						}
						System.out.println("Id:" + customer.getId() + "\tName:" + customer.getName());
					}
					
					break;
			}
		}
	}
}






























