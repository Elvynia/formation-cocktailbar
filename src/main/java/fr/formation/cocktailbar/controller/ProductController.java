package fr.formation.cocktailbar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.cocktailbar.dao.ProductRepository;

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

}
