package fr.elvynia.formation.cocktailbar.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.elvynia.formation.cocktailbar.entity.Product;
import fr.elvynia.formation.cocktailbar.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("productList", this.productService.getAll());
		return "product/list";
	}
	
	@RequestMapping("/edit/{id}")
	public String form(@PathVariable Integer id, Model model) {
		model.addAttribute("product", this.productService.read(id));
		return "product/edit";
	}
	
	@PostMapping("/edit")
	public String create(Integer id, String name, Integer stock) {
		Product newProduct = new Product();
		newProduct.setName(name);
		newProduct.setStock(stock);
		if (id != null) {
			newProduct.setId(id);
			this.productService.update(newProduct);
		}
		this.productService.create(newProduct);
		return "product/edit";
	}
	
	@GetMapping("/delete")
	public String delete(Integer id) {
		this.productService.delete(id);
		return "redirect:/product/";
	}
}
