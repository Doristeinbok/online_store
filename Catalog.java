package online_store;


import java.util.List;
import java.util.ArrayList;


public class Catalog {
	private int CAPACITY = 10;
	private List<Product> products = new ArrayList<>();
	
	public Catalog(String[] producArr) {
		for(int i = 0; i < CAPACITY; ++i) {
			products.add(new Product(i, producArr[i]));
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