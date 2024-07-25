package in.ineuron.service;

import java.util.List;

import in.ineuron.model.GroceryItem;

public interface GroceryService {
	
	String insert(GroceryItem item);
	
	GroceryItem findById(String id);
	
	List<GroceryItem> getData();
	
	List<GroceryItem> getByName(String name);
	
	List<GroceryItem> findByPriceBetween(double min, double max);
	
	GroceryItem updateItem(GroceryItem item);
	
	String deleteById(String id);
}
