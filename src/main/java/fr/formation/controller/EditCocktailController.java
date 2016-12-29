package fr.formation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.entity.Cocktail;
import fr.formation.entity.CocktailPart;
import fr.formation.service.CocktailService;
import fr.formation.service.IngredientService;

/**
 * Controleur appelé dès qu'une URL commence par '/cocktail'. Ses méthodes
 * permettent de gérer l'affichage de la page de modification d'un cocktail et
 * les différentes interractions possibles sur la page.
 *
 * @author hb-asus
 *
 */
@Controller
@RequestMapping("/cocktail")
public class EditCocktailController {

	/**
	 * Mémorisation de l'identifiant du cocktail en cours de modification sur la
	 * page.
	 */
	private Integer cocktailId;

	/**
	 * Liste des ingrédients avec quantités durant la modification du cocktail.
	 */
	private List<CocktailPart> cocktailParts;

	/**
	 * Injection du service permettant d'intéragir avec les cocktails en base de
	 * données.
	 */
	@Autowired
	private CocktailService cocktailService;

	/**
	 * Mémorisation d'un booléen dans l'instance du controleur pour savoir si il
	 * faut mettre une nouvelle instance de l'objet Cocktail dans le modèle ou
	 * non (pour garder les messages d'erreurs à l'affichage).
	 */
	private boolean error;

	/**
	 * Injection du service permettant d'intéragir avec les ingrédients en base
	 * de données.
	 */
	@Autowired
	private IngredientService ingredientService;

	/**
	 * Méthode d'initialisation appelée après le constructeur et après
	 * l'injection des instances en Autowired.
	 */
	@PostConstruct
	public void _init() {
		this.cocktailParts = new ArrayList<>();
	}

	/**
	 * Méthode permettant d'associer un nouvel ingrédient avec le cocktail en
	 * cours de modifications.
	 *
	 * @param ingredientId l'identifiant de l'ingrédient.
	 * @return String une URL qui redirige vers la page à afficher.
	 */
	@RequestMapping("/addIngredient")
	public String addIngredient(@RequestParam final Integer ingredientId) {
		final CocktailPart cocktailPart = new CocktailPart();
		cocktailPart.setCocktail(this.cocktailService.get(this.cocktailId));
		cocktailPart.setIngredient(this.ingredientService.get(ingredientId));
		this.cocktailParts.add(cocktailPart);
		return this.getForward();
	}

	/**
	 * Méthode permettant de charger la vue de modification d'un cocktail. Cette
	 * méthode est systématiquement appelée lors d'une intéraction
	 * client/serveur pour pouvoir recharger la page JSP. Elle contient aussi le
	 * chargement du modèle dans lequel il y a les objets Java utiles pour
	 * afficher la page.
	 *
	 * @param id l'identifiant du cocktail à modifier.
	 * @return ModelAndView l'objet de Spring qui sert à compiler/charger la
	 *         page JSP.
	 */
	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable final Integer id) {
		if (this.cocktailId != null && !this.cocktailId.equals(id)) {
			this.cocktailParts = new ArrayList<>();
			if (this.cocktailParts.isEmpty()) {
				this.cocktailParts.addAll(
						this.cocktailService.getCocktailParts(this.cocktailId));
			}
		}
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("editCocktail");
		if (this.error) {
			this.error = false;
		} else {
			final Cocktail cocktail = this.cocktailService.get(id);
			mav.addObject("cocktail", cocktail);
			this.cocktailId = cocktail.getId();
		}
		mav.addObject("cocktailParts", this.cocktailParts);
		mav.addObject("ingredients",
				this.ingredientService.getAllByCocktail(this.cocktailParts));
		return mav;
	}

	/**
	 * Méthode privée permettant de construire l'URL de redirection vers la
	 * méthode edit() qui renvoi l'objet ModelAndView.
	 *
	 * @return String l'URL vers l'édition du coktail.
	 */
	private String getForward() {
		return "forward:/cocktail/edit/" + this.cocktailId + ".html";
	}

	/**
	 * Méthode permettant de retirer l'association entre un ingrédient et le
	 * cocktail en cours de modifications.
	 *
	 * @param ingredientId l'identifiant de l'ingrédient.
	 * @return String une URL qui redirige vers la page à afficher.
	 */
	@RequestMapping("/removeIngredient")
	public String removeIngredient(@RequestParam final Integer ingredientId) {
		final CocktailPart cocktailPart = new CocktailPart();
		cocktailPart.setCocktail(this.cocktailService.get(this.cocktailId));
		cocktailPart.setIngredient(this.ingredientService.get(ingredientId));
		this.cocktailParts.remove(cocktailPart);
		return this.getForward();
	}

	/**
	 * Méthode permettant de sauvegarder en base de données les modifications
	 * apportées au cocktail (nom et prix).
	 *
	 * @param cocktail l'objet modifié et lié aux champs HTML de la page
	 *            (ModelAttribute).
	 * @return String une URL qui redirige vers la page à afficher.
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute @Valid final Cocktail cocktail,
			final BindingResult result) {
		if (result.hasErrors()) {
			this.error = true;
		} else {
			this.cocktailService.update(cocktail);
		}
		return this.getForward();
	}

	/**
	 * Méthode permettant de sauvegarder l'association des ingrédients et de
	 * leurs quantités (CocktailPart) avec le cocktail en cours de
	 * modifications.
	 *
	 * @param request l'objet représentant la requête HTTP.
	 * @return String une URL qui redirige vers la page à afficher.
	 */
	@RequestMapping(value = "/saveIngredients", method = RequestMethod.POST)
	public String saveIngredients(final HttpServletRequest request) {
		this.cocktailParts.forEach((final CocktailPart cocktailPart) -> {
			final int quantity = Integer.parseInt(request.getParameter(
					"quantity_" + cocktailPart.getIngredient().getId()));
			cocktailPart.setQuantity(quantity);
		});
		this.cocktailService.updateCocktailParts(this.cocktailId,
				this.cocktailParts);
		return this.getForward();
	}

}
