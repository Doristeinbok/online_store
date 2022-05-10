package online_store.enteties.implementation;


import java.util.List;
import java.util.ArrayList;

import online_store.enteties.Catalog;
import online_store.enteties.Product;


public class DefaultCatalog implements Catalog{
	private int CAPACITY = 10;
	private List<Product> products = new ArrayList<>();
	
	public DefaultCatalog(String[] producArr) {
		for(int i = 0; i < CAPACITY; ++i) {
			products.add(new DefaultProduct(i, producArr[i]));
		}
	}
		
	public List<Product> getProducts() {
		return products;
	}
	
	public Product getProductById(int id) {
		for(Product product : products) {
			if(product.getId() == id) {
				return product;
			}
		}
		
		return null;
	}
}