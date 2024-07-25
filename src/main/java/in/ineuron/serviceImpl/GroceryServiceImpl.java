package in.ineuron.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.Repository.GroceryRepository;
import in.ineuron.model.GroceryItem;
import in.ineuron.service.GroceryService;

@Service
public class GroceryServiceImpl implements GroceryService{

	@Autowired
	private GroceryRepository repository;
	
	
	@Override
	public String insert(GroceryItem item) {
		
		GroceryItem data = repository.insert(item);
		if(data != null)
			return "Document saved Successfully";
		else
			return "Issue while saving the Document";
	}

	@Override
	public List<GroceryItem> getData() {
		return repository.findAll();
	}
	
	@Override
	public GroceryItem findById(String id) {
		GroceryItem groceryItem = repository.findById(id).get();
		return groceryItem;
	}

	@Override
	public List<GroceryItem> getByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public List<GroceryItem> findByPriceBetween(double min, double max) {
		return repository.findByPriceBetween(min, max);
	}

	@Override
	public GroceryItem updateItem(GroceryItem item) {
		return repository.save(item);
	}

	@Override
	public String deleteById(String id) {
		
		if(findById(id) != null) {
			
			repository.deleteById(id);
			return "Item with id "+id +" deleted successfully";
		}
		return "Issue in deleting item";
	}
	

}
