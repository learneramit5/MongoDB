package in.ineuron.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "groceryitems")
public class GroceryItem {
	

    private String name;
    private int quantity;
    private String category;
    private Double price;
}
