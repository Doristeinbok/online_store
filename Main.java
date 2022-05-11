package online_store;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


import online_store.enteties.implementation.DefaultCatalog;
import online_store.enteties.implementation.DefaultCustomer;
import online_store.enteties.implementation.DefaultCart;
import online_store.enteties.Catalog;
import online_store.enteties.Product;
import online_store.configs.ApplicationContex;



public class Main {
	
	private static List<DefaultCustomer> customers = new ArrayList<>();
	private static int DEFAULT_INITIAL_USERS = 10;
	private static int lastUserIndex = 0; 
	
	static {
		customers.add(new DefaultCustomer(0, "dori", "dori@gmail.com", 1234));
		customers.add(new DefaultCustomer(1, "gili", "gili@gmail.com", 1234));
		customers.add(new DefaultCustomer(2, "lior", "lior@gmail.com", 1234));
		customers.add(new DefaultCustomer(3, "beeri", "beeri@gmail.com", 1234));
		lastUserIndex = 4;
	}
	
	public static void main(String[] args) {
		int number;
		String name = "";
		String email = "";
		String answer = "";
		int password;	
		
//		instantiate application instance
		ApplicationContex instance = new ApplicationContex();		
		
		
		String[] itemsToCatalog= {"computer", "mouse", "keyboard", "cable", "phone",
							"desk", "chair", "book", "air condi	tioner", "pen"};
		Catalog catalog = new DefaultCatalog(itemsToCatalog);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("************ General form ************");
			System.out.print("1. Sign up\t\t");
			System.out.println("4. My Orders");
			if(null == instance.getLoggedInCustomer()) {
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
					System.out.println("Please insert your email");
					email = sc.next();
					System.out.println("Please insert password");
					password = sc.nextInt();
					
					customers.add(new DefaultCustomer(lastUserIndex, name, email, password));	
//					lastUserIndex++;
//					TODO decide when to increment lastUserIndex
					instance.setLoggedInCustomer(customers.get(customers.size() - 1));
					
					break;
					
				case 2: //sign in or sign out
					if(null != instance.getLoggedInCustomer()) {
						instance.setLoggedInCustomer(null);
						System.out.println("You just signed out!");
						break;
					}
					
					System.out.println("what is your name?");
					name = sc.next();
					
					for(DefaultCustomer customer : customers) {
						if(customer == null) {
							System.out.println("empty array");
							break;
						}
						if (customer.getName().equals(name)) {
							System.out.println("Insert password");
							password = sc.nextInt();
							if(customer.getPassword() == password) {
								System.out.println("Welcome back, " + name);
								instance.setLoggedInCustomer(customer);
								break;
							} else {
								System.out.println("Wrong id, " + name);
								break;
							}
						}
					}
					
					break;
					
				case 3: //product catalog
					if(instance.getLoggedInCustomer() == null) {
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
						
						DefaultCart cart = ((DefaultCustomer) instance.getLoggedInCustomer()).getCart();
						Product productToAdd = ((DefaultCatalog)catalog).getProductById(itemId);
						
						cart.addProduct(productToAdd);
						System.out.println(productToAdd.getName() + " was added to cart");
						
						System.out.println("do you want to continue shopping? (y/n)");
						answer = sc.next().toLowerCase();
						
					}while(answer.equalsIgnoreCase("y"));
					
					System.out.println("Hope you enjoyed shopping!");
					break;
					
				case 4: //My orders
					if(instance.getLoggedInCustomer() == null) {
						System.out.println("Please sign in first");
						break;
					}
					
					DefaultCart currentCart = ((DefaultCustomer)instance.getLoggedInCustomer()).getCart();
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
					
				case 5:
					if(null == instance.getLoggedInCustomer()) {
						System.out.println("Please sign in first");
						break;
					}
					
					int flag = 1;
					while(1 == flag) {
						System.out.println("please enter new email");
						email = sc.next();
						if(email == ((DefaultCustomer)instance.getLoggedInCustomer()).getEmail()) {
							System.out.println("The new email is the same as the old one");
							continue;
						}
						
						((DefaultCustomer)instance.getLoggedInCustomer()).setEmail(email);
						System.out.println("Your new email \"" + email + "\" is set");
						flag = 0;
					}
					
					break;
					
				case 6: //Customer List
					if(null != instance.getLoggedInCustomer()) {
						System.out.println("You are viewing this list as " + ((DefaultCustomer)instance.getLoggedInCustomer()).getName());
					}
					
					System.out.println("Customer List:");
					for(DefaultCustomer customer : customers) {
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






























