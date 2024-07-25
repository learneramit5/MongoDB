package in.ineuron.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.ineuron.model.GroceryItem;

public interface GroceryRepository extends MongoRepository<GroceryItem, String> {
	
	List<GroceryItem> findByName(String name);
	
	List<GroceryItem> findByPriceBetween(double min, double max);
	

}
