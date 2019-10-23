package fr.elvynia.formation.cocktailbar.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.elvynia.formation.cocktailbar.entity.Product;
import fr.elvynia.formation.cocktailbar.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductWebService {
	
	@Autowired	
	private ProductService productService;

	@GetMapping({ "", "/" })
	public List<Product> list() {
		return this.productService.getAll();
	}
}
