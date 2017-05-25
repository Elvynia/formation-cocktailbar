package fr.formation.cocktailbar.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.cocktailbar.dao.ProductRepository;
import fr.formation.cocktailbar.entity.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	/**
	 * Bean singleton injecté via le context Spring.
	 */
	@Autowired
	private ProductRepository repository;

	/**
	 * Méthode liée à l'affichage de la liste des produits.
	 * 
	 * @return Vue product/list.jsp, Model avec liste des produits.
	 */
	@RequestMapping("/index")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("product/list");
		mav.getModel().put("productList", this.repository.findAll());
		return mav;
	}

	@RequestMapping(path = "/edit", method = RequestMethod.GET)
	public ModelAndView showCreateProduct() {
		return new ModelAndView("product/edit");
	}

	/**
	 * Méthode liée à une url paramétrée. Cette méthode n'est déclenchée que lorsque l'URL comporte une valeur numérique
	 * (car le type du paramètre est Integer). Ex : '/product/edit/3.html'.
	 * 
	 * @param id
	 *            l'identifiant du produit à mettre à jour.
	 * @return Vue product/edit.jsp, Model avec informations du produit à modifier.
	 */
	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdateProduct(@PathVariable("id") final Integer id) {
		if (this.repository.exists(id)) {
			final ModelAndView mav = new ModelAndView("product/edit");
			mav.getModel().put("product", this.repository.findOne(id));
			return mav;
		} else {
			ProductController.LOGGER
					.warn("Product with id={} does not exists in database. Switching to product creation.", id);
			return this.showCreateProduct();
		}
	}

	@RequestMapping(path = "/edit", method = RequestMethod.POST)
	public String createOrUpdateProduct(final HttpServletRequest request) {
		final String name = request.getParameter("name");
		final Integer stock = Integer.parseInt(request.getParameter("stock"));
		final Product product = new Product();
		if (request.getParameterMap().containsKey("id")) {
			product.setId(Integer.parseInt(request.getParameter("id")));
		}
		product.setName(name);
		product.setStock(stock);
		// Si l'identifiant du produit est rempli, alors l'update se fera automatiquement à la place de l'insert.
		this.repository.save(product);
		return "redirect:/product/";
	}
}
