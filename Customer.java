package online_store;


public class Customer {
	private int id;
	private String name;
	private String email;
	private int password;
	private Cart cart;
	
	public Customer(int id, String name, int passward) {
		this.id = id;
		this.name = name;
		this.password = passward;
		setCart(new Cart(name + "'s cart"));
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
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
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