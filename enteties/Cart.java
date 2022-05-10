package online_store.enteties;

import java.util.List;


public interface Cart {
	void addProduct(Product product);
	List<Product> getProducts();
}
