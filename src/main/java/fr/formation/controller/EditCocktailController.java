package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.service.CocktailService;

@Controller
@RequestMapping("/cocktail")
public class EditCocktailController {

	@Autowired
	private CocktailService cocktailService;

	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable final Integer id) {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("editCocktail");
		mav.addObject("cocktail", this.cocktailService.get(id));
		return mav;
	}
}
