package fr.formation.cocktailbar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.cocktailbar.dao.CocktailDao;
import fr.formation.cocktailbar.entity.Cocktail;

@Controller
@RequestMapping("/cocktail")
public class CocktailController {
	
	@Autowired
	private CocktailDao cocktailDao;

	@RequestMapping({"", "/"})
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("cocktail/list");
		mav.getModel().put("cocktailList", this.cocktailDao.findAll());
		return mav;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam final Integer id) {
		this.cocktailDao.delete(id);
		// Return identique à 'this.index()'.
		return "redirect:/cocktail/";
	}
	
	@RequestMapping("/add")
	public String showAdd(final Model model) {
		model.addAttribute("cocktail", new Cocktail());
		return "cocktail/edit";
	}
	
	@RequestMapping("/edit")
	public ModelAndView showEdit(@RequestParam final Integer id) {
		final ModelAndView mav = new ModelAndView("cocktail/edit");
		mav.getModel().put("cocktail", this.cocktailDao.findOne(id));
		return mav;
	}
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute final Cocktail cocktail) {
		this.cocktailDao.save(cocktail);
		return this.index();
	}
}
