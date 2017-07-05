package fr.formation.cocktailbar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.cocktailbar.dao.ProductDao;
import fr.formation.cocktailbar.entity.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("product/list");
		return mav;
	}

	@RequestMapping("/add")
	public String showAdd() {
		return "product/add";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String add(final Model model, @RequestParam final String name,
			@RequestParam("stock") final Integer productCount) {
		final Product product = new Product();
		product.setName(name);
		product.setStock(productCount);
		this.productDao.save(product);
		return "product/add";
	}
}
