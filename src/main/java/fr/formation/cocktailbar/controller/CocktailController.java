package fr.formation.cocktailbar.controller;

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
import org.springframework.web.servlet.ModelAndView;

import fr.formation.cocktailbar.dao.CocktailRepository;
import fr.formation.cocktailbar.entity.Cocktail;

@Controller
@RequestMapping("/cocktail")
public class CocktailController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CocktailController.class);

	@Autowired
	private CocktailRepository repository;

	@RequestMapping("/index")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("cocktail/list");
		mav.getModel().put("cocktailList", this.repository.findAll());
		return mav;
	}

	@RequestMapping(path = "/edit/{id}")
	public String showUpdate(final Model model, @PathVariable final Integer id) {
		if (this.repository.exists(id)) {
			model.addAttribute("cocktail", this.repository.findOne(id));
			return "/cocktail/edit";
		} else {
			CocktailController.LOGGER
					.warn("Trying to update a cocktail with a unknown id '{}' in database. Switching to creation.", id);
			return this.showCreate(model);
		}
	}

	@RequestMapping(path = "/edit", method = RequestMethod.GET)
	public String showCreate(final Model model) {
		model.addAttribute("cocktail", new Cocktail());
		return "cocktail/edit";
	}

	@RequestMapping(path = "/edit", method = RequestMethod.POST)
	public String createOrUpdate(@ModelAttribute final Cocktail cocktail) {
		// L'identifiant étant déjà pré-rempli par Spring si il était présent dans la page, aucune condition à gérer
		// pour distinguer la création de la mise à jour.
		this.repository.save(cocktail);
		return "redirect:/cocktail/";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam final Integer id) {
		if (this.repository.exists(id)) {
			this.repository.delete(id);
		} else {
			CocktailController.LOGGER.warn("Cannot delete cocktail, id={} does not exists in database.", id);
		}
		return "redirect:/cocktail/";
	}
}
