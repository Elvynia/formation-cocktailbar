package fr.formation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.entity.Ingredient;
import fr.formation.service.IngredientService;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {

	@Autowired
	private IngredientService service;

	@RequestMapping("/add")
	public ModelAndView add() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("addIngredient");
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable final Integer id) {
		this.service.delete(id);
		return "redirect:/ingredients.html";
	}

	@RequestMapping
	public ModelAndView list() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("ingredients");
		mav.addObject("ingredients", this.service.getAll());
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String newIngredient(final HttpServletRequest request) {
		final String name = request.getParameter("name");
		final Integer state = Integer.parseInt(request.getParameter("state"));
		this.service.create(new Ingredient(name, state));
		return "redirect:/ingredients/add.html";
	}

	@RequestMapping(value = "/add2", method = RequestMethod.POST)
	public String newIngredient2(@RequestParam final String name,
			@RequestParam final Integer state) {
		this.service.create(new Ingredient(name, state));
		return "redirect:/ingredients/add.html";
	}
}
