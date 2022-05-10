package online_store.enteties.implementation;

import online_store.enteties.Customer;


public class DefaultCustomer implements Customer{
	private int id;
	private String name;
	private String email;
	private int password;
	private DefaultCart cart;
	
	public DefaultCustomer(int id, String name, String email, int passward) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = passward;
		setCart(new DefaultCart(name + "'s cart"));
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
	
	public DefaultCart getCart() {
		return cart;
	}

	public void setCart(DefaultCart cart) {
		this.cart = cart;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return this.id +"\t" + this.name + "\n";
	}
}