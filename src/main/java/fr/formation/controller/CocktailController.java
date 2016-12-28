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

	@Autowired
	private CocktailService service;

	@RequestMapping("/add")
	public ModelAndView add() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("addCocktail");
		return mav;
	}

	@RequestMapping
	public ModelAndView list() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("cocktails");
		mav.addObject("cocktails", this.service.getAll());
		return mav;
	}

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
