package fr.formation.cocktailbar.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.cocktailbar.dao.CocktailDao;
import fr.formation.cocktailbar.dao.IngredientDao;
import fr.formation.cocktailbar.dao.ProductDao;
import fr.formation.cocktailbar.entity.Cocktail;
import fr.formation.cocktailbar.entity.Ingredient;
import fr.formation.cocktailbar.entity.Product;

@Controller
@RequestMapping("/ingredient")
@SessionAttributes({ "ingredientList", "productList", "cocktail" })
public class IngredientController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(IngredientController.class);

	@Autowired
	private CocktailDao cocktailDao;

	@Autowired
	private IngredientDao ingredientDao;

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/{id}")
	public ModelAndView index(@PathVariable final Integer id) {
		// Préparation de l'objet vue/modèle avec nom de la vue.
		final ModelAndView mav = new ModelAndView("ingredient/edit");
		// Récupération du cocktail en BDD puis chargement dans le modèle.
		mav.getModel().put("cocktail", this.cocktailDao.findOne(id));
		// Préparation de la liste des ingrédients.
		final List<Ingredient> ingredientList = new ArrayList<>();
		// Récupération des ingrédients faisant déjà partie de la recette
		// (présent en BDD).
		ingredientList.addAll(this.ingredientDao.findAllByCocktailId(id));
		// Chargement de la liste des ingrédients dans le modèle.
		mav.getModel().put("ingredientList", ingredientList);
		// Récupération de la liste des produits.
		final List<Product> productList = this.productDao.findAll();
		// Filtrage des produits qui sont déjà dans les ingrédients.
		// Autre possibilité par surcharge de la méthode equals dans Product :
		// productList.removeAll(ingredientList);
		for (final Ingredient ingredient : ingredientList) {
			// Le produit est retrouvé par comparaison des propriétés id (c.f.
			// equals).
			productList.remove(ingredient.getProduct());
		}
		// Chargement de la liste des produits dans le modèle.
		mav.getModel().put("productList", productList);
		return mav;
	}
	
	@RequestMapping("/view/{id}")
	public ModelAndView view(@PathVariable final Integer id) {
		final ModelAndView mav = new ModelAndView("ingredient/list");
		mav.addObject("ingredientList", this.ingredientDao.findAllByCocktailId(id));
		return mav;
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addProduct(final Model model,
			@RequestParam final Integer productId,
			@RequestParam final Float quantity) {
		// Construction d'un nouvel ingrédient à partir des paramètres envoyés
		// du client.
		final Ingredient ingredient = new Ingredient();
		ingredient.setCocktail((Cocktail) model.asMap().get("cocktail"));
		ingredient.setProduct(this.productDao.findOne(productId));
		ingredient.setQuantity(quantity);
		// Ajout de l'ingrédient dans la liste stockée en session.
		@SuppressWarnings("unchecked")
		final List<Ingredient> ingredientList = (List<Ingredient>) model.asMap()
				.get("ingredientList");
		ingredientList.add(ingredient);
		// Retirer le produit ajouté de la liste des produits disponibles.
		@SuppressWarnings("unchecked")
		final List<Product> productList = (List<Product>) model.asMap()
				.get("productList");
		productList.remove(ingredient.getProduct());
		return "ingredient/edit";
	}

	@RequestMapping("/delete/{productId}")
	public String removeProduct(
			@ModelAttribute final List<Ingredient> ingredientList,
			@ModelAttribute final List<Product> productList,
			@PathVariable final Integer productId) {
		// Retrouver l'ingrédient correspondant à l'identifiant du produit passé en paramètre.
		int index = -1;
		for (final Ingredient ingredient : ingredientList) {
			if (ingredient.getProduct().getId().equals(productId)) {
				index = ingredientList.indexOf(ingredient);
				break;
			}
		}
		if (index >= 0) {
			final Ingredient ingredient = ingredientList.remove(index);
			productList.add(ingredient.getProduct());
			// this.ingredientDao.delete(ingredient);
		}
		return "ingredient/edit";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute final List<Ingredient> ingredientList,
			@ModelAttribute final Cocktail cocktail) {
		IngredientController.LOGGER.debug("Suppression et sauvegarde des ingrédients du cocktail.");
		this.ingredientDao.deleteAllByCocktailId(cocktail.getId());
		this.ingredientDao.save(ingredientList);
		return "redirect:/cocktail/";
	}
	
	
	
	
	
	
	
	
	
}
