package fr.formation.cocktailbar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductDao productDao;

	@RequestMapping({"", "/"})
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("product/list");
		mav.getModel().put("productList", this.productDao.findAll());
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam Integer id) {
		this.productDao.delete(id);
		return this.index();
	}
	
	@RequestMapping("/edit")
	public String showEdit(final Model model, @RequestParam Integer id) {
		model.addAttribute("product", this.productDao.findOne(id));
		return "product/edit";
	}

	@RequestMapping("/add")
	public String showAdd() {
		return "product/edit";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ModelAndView add(final Model model, @RequestParam final String name,
			@RequestParam("stock") final Integer productCount,
			@RequestParam(required=false) final Integer id) {
		final Product product = new Product();
		if (id != null) {
			product.setId(id);
		}
		product.setName(name);
		product.setStock(productCount);
		try {
			this.productDao.save(product);
			// Save effectué avec succès.
			if (id != null) {
				model.addAttribute("message", "Le produit a bien été mis à jour");
			} else {
				model.addAttribute("message", "Le produit à bien été créé.");
			}
			model.addAttribute("error", false);
		} catch (final DataAccessException e) {
			ProductController.LOGGER.error("Failed to add a new product : ", e);
			// Save interrompu par une exception.
			model.addAttribute("message", "Une erreur a empêchée la création du produit.");
			model.addAttribute("error", true);
		}
		return this.index();
	}
}
