package fr.formation.cocktailbar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.cocktailbar.dao.CocktailRepository;
import fr.formation.cocktailbar.entity.Cocktail;

@Controller
@RequestMapping("/cocktail")
public class CocktailController {

	@Autowired
	private CocktailRepository repository;

	@RequestMapping("/index")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("cocktail/list");
		mav.getModel().put("cocktailList", this.repository.findAll());
		return mav;
	}

	@RequestMapping(path = "/edit", method = RequestMethod.GET)
	public String newCocktail(final Model model) {
		model.addAttribute("newCocktail", new Cocktail());
		return "cocktail/edit";
	}

	@RequestMapping(path = "edit", method = RequestMethod.POST)
	public String createCocktail(@ModelAttribute("newCocktail") final Cocktail cocktail) {
		this.repository.save(cocktail);
		return "redirect:/cocktail/";
	}

}
