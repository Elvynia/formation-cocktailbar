package fr.formation.cocktailbar.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.cocktailbar.dao.CocktailRepository;
import fr.formation.cocktailbar.dao.IngredientRepository;
import fr.formation.cocktailbar.dao.ProductRepository;
import fr.formation.cocktailbar.entity.Cocktail;
import fr.formation.cocktailbar.entity.Ingredient;
import fr.formation.cocktailbar.entity.Product;

@Controller
@RequestMapping("/ingredient")
@SessionAttributes({ "ingredientList", "productList", "cocktail" })
public class IngredientController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IngredientController.class);

	@Autowired
	private CocktailRepository cocktailRepository;

	@Autowired
	private IngredientRepository ingredientRepository;

	@Autowired
	private ProductRepository productRepository;

	@ModelAttribute
	public List<Ingredient> ingredientList() {
		return new ArrayList<>();
	};

	@ModelAttribute
	public List<Product> productList() {
		return new ArrayList<>();
	}

	@RequestMapping("/edit")
	public ModelAndView showEdit(@RequestParam final Integer cocktailId,
			@ModelAttribute final List<Ingredient> ingredientList, @ModelAttribute final List<Product> productList) {
		ModelAndView mav = new ModelAndView("ingredient/edit");
		mav.getModel().put("cocktail", this.cocktailRepository.findOne(cocktailId));

		productList.clear();
		productList.addAll(this.productRepository.findAll());
		final List<Ingredient> currentIngredientList = this.ingredientRepository.findAllByCocktailId(cocktailId);
		// FIXME: Can the result from repo be null when using findAll ?
		if (currentIngredientList != null) {
			ingredientList.clear();
			ingredientList.addAll(currentIngredientList);
			for (final Ingredient ingredient : currentIngredientList) {
				productList.remove(ingredient.getProduct());
			}
		}
		return mav;
	}

	@RequestMapping(path = "/edit/add")
	public String addIngredient(@RequestParam final Integer productId, @RequestParam final Float quantity,
			@ModelAttribute List<Ingredient> ingredientList, @ModelAttribute final Cocktail cocktail,
			@ModelAttribute List<Product> productList) {
		final Ingredient ingredient = new Ingredient();
		ingredient.setCocktail(cocktail);
		ingredient.setProduct(this.productRepository.findOne(productId));
		ingredient.setQuantity(quantity);
		ingredientList.add(ingredient);
		productList.remove(ingredient.getProduct());
		return "ingredient/edit";
	}

	@RequestMapping("/edit/remove")
	public String removeIngredient(@RequestParam final Integer productId, @ModelAttribute final Cocktail cocktail,
			@ModelAttribute List<Ingredient> ingredientList, @ModelAttribute List<Product> productList) {
		if (ingredientList.remove(new Ingredient(cocktail, this.productRepository.findOne(productId)))) {
			productList.add(this.productRepository.findOne(productId));
		}
		return "/ingredient/edit";
	}

	@RequestMapping("/edit/validate")
	public String validateAndPersist(@ModelAttribute List<Ingredient> ingredientList,
			@ModelAttribute final Cocktail cocktail) {
		LOGGER.debug("Validating list of ingredient with cocktailId={} and ingredients={}", cocktail.getId(),
				ingredientList);
		// Dans un premier temps il faut supprimer les éventuels ingrédients déjà existant et associés à ce cocktail.
		this.ingredientRepository.deleteByCocktailId(cocktail.getId());
		// Et la magie de Spring nous permet de passer en paramètre toute notre liste d'un coup grâce à l'interface
		// Iterable<Ingredient> implémentée par List<Ingrédient> !
		this.ingredientRepository.save(ingredientList);
		// TODO: end session scope.
		return "redirect:/cocktail/";
	}
}
