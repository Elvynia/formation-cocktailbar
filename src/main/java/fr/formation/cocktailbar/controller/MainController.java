package fr.formation.cocktailbar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.cocktailbar.model.MenuItem;

@Controller
public class MainController {
	
	@Autowired
	private MessageSource messageSource;

	@RequestMapping({"", "/", "/index.html"})
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.getModel().put("title", "Hello Wolrd Spring !");
		mav.getModel().put("menu", this.buildMenu());
		return mav;
	}

	private List<MenuItem> buildMenu() {
		final List<MenuItem> menu = new ArrayList<>();
		// Récupérer la liste des items avec la clé 'menu'.
		final String items = getMessage("menu");
		for (final String item : items.split(" *, *")) {
			final String title = this.getMessage(item + ".title");
			final String url = this.getMessage(item + ".url");
			menu.add(new MenuItem(title, url));
		}
		return menu;
	}

	private String getMessage(String key) {
		return this.messageSource.getMessage(key, null, Locale.getDefault());
	}
}
