package tn.esprit.shop.shop.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.shop.shop.persistence.Category;
import tn.esprit.shop.shop.persistence.Product;

@Remote
public interface CatalogServiceRemote {
	
	Product createProduct(Product product);
	void saveProduct(Product product);
	void removeProduct(Product product);
	List<Product> findAllProducts();
	
	List<Product> findProductsByCategory(Category category);
	
	
	Category createCategory(Category category);
	void saveCategory(Category category);
	void removeCategory(Category category);
	List<Category> findAllCategories();
	Category findCategoryByName(String name);
	
	byte[] findPictureByProductName(String productName);
	
	

}
