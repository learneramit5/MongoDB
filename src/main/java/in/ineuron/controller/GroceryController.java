package in.ineuron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.GroceryItem;
import in.ineuron.service.GroceryService;

@RestController
public class GroceryController {
	
	@Autowired
	private GroceryService service;
	
	
	
	
	@PostMapping("/saveItems")
	public ResponseEntity<String> saveItem(@RequestBody GroceryItem item) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(item));
		
	}
	
	@GetMapping("getItems")
	public ResponseEntity<List<GroceryItem>> getItem(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getData());
		
	}
	
	@GetMapping("getItemsById/{id}")
	public ResponseEntity<?> getItemById(@PathVariable String id){
		
		if(service.findById(id) != null)
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Found");

		
	}
	
	@GetMapping("getItemsByName")
	public List<GroceryItem> getByName(@RequestParam String name){
		return service.getByName(name);
	}
	
	@GetMapping("getItemsByPriceRange")
	public List<GroceryItem> getItemsByPriceRange(@RequestParam double min, @RequestParam double max){
		return service.findByPriceBetween(min, max);
	}
	
	@PutMapping("/updateItem")
	public ResponseEntity<?> UpdateItem(@RequestBody GroceryItem item, @RequestParam String id) {
		
		
		if(service.findById(id) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(service.updateItem(item));
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Found to Update");
		
	}
	
	@DeleteMapping("/deleteItem/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable String id){
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteById(id));
		
	}
	

}
