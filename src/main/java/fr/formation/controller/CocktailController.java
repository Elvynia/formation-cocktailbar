package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.entity.Cocktail;
import fr.formation.service.CocktailService;

/**
 * Controleur appelé dès qu'une URL commence par '/cocktails'. Ses méthodes
 * permettent de gérer l'affichage de la liste des cocktails ainsi que de gérer
 * le formulaire d'ajout d'un nouveau cocktail.
 *
 * @author hb-asus
 *
 */
@Controller
@RequestMapping("/cocktails")
public class CocktailController {

	/**
	 * Injection du service permettant de gérer l'accès des cocktails en base.
	 */
	@Autowired
	private CocktailService service;

	/**
	 * Méthode permettant de rediriger vers la page d'ajout d'un cocktail.
	 *
	 * @return ModelAndView l'objet Spring avec le nom de vue correspondant à
	 *         une page JSP.
	 */
	@RequestMapping("/add")
	public ModelAndView add() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("addCocktail");
		return mav;
	}

	/**
	 * Méthode permettant de rediriger vers la page de liste des cocktails. On
	 * ajoute la liste des cocktails récupérés du service dans le Model afin que
	 * la liste soit utilisable depuis la page JSP.
	 *
	 * @return ModelAndView l'objet Spring avec le nom de vue correspondant à
	 *         une page JSP.
	 */
	@RequestMapping
	public ModelAndView list() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("cocktails");
		mav.addObject("cocktails", this.service.getAll());
		return mav;
	}

	/**
	 * Méthode de confirmation d'ajout d'un nouveau cocktail. On récupère grâce
	 * aux annotations RequestParam les valeurs des paramètres de la requête
	 * HTTP POST.
	 *
	 * @param name le nom du coktail.
	 * @param price le prix du cocktail.
	 * @param withAlcohol vrai si le cocktail est alcoolisé, sinon null.
	 * @return String une URL de redirection vers la page d'ajout d'un cocktail.
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String newCocktail(@RequestParam final String name,
			@RequestParam final Float price,
			@RequestParam(required = false) final Boolean withAlcohol) {
		final Cocktail cocktail = new Cocktail();
		cocktail.setName(name);
		System.out.println("Cocktail name : " + name);
		cocktail.setPrice(price);
		cocktail.setWithAlcohol(withAlcohol != null);
		this.service.create(cocktail);
		return "redirect:/cocktails/add.html";
	}

}
