package online_store.enteties.implementation;


import java.util.ArrayList;
import java.util.List;

import online_store.enteties.Cart;
import online_store.enteties.Product;


public class DefaultCart implements Cart{
	private String name;
	private int amount;
	private List<Product> products = new ArrayList<>(); 

	
	public DefaultCart(String name) {
		this.name = name;
	}
	
	public void addProduct(Product product) {
		if(null == product) {
			throw new IllegalArgumentException("The product you want to add is null");
		}
		
		products.add(product);
	}
	
	public List<Product>getProducts() {
		return products;
	}

	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}