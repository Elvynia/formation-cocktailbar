package fr.formation.cocktailbar.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.cocktailbar.dao.ProductRepository;
import fr.formation.cocktailbar.entity.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository repository;

	@RequestMapping("/index")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("product");
		mav.getModel().put("productList", this.repository.findAll());
		return mav;
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public ModelAndView newProduct() {
		return new ModelAndView("createProduct");
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String createProduct(final HttpServletRequest request) {
		final String name = request.getParameter("name");
		final Integer stock = Integer.parseInt(request.getParameter("stock"));
		final Product product = new Product();
		product.setName(name);
		product.setStock(stock);
		this.repository.save(product);
		return "redirect:".concat("/product/");
	}
}
