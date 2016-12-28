package fr.formation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.model.Menu;

/**
 * Controleur principal permettant de gérer l'URL '/' (qui implicitement donne
 * '/index.html') et d'afficher la page de menu de l'application.
 *
 * @author hb-asus
 *
 */
@Controller
public class MainController {

	@Autowired
	private MessageSource messages;

	private String getMessage(final String key) {
		return this.messages.getMessage(key, null, null);
	}

	@RequestMapping("/index")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		final List<String> menuKeys = Arrays
				.asList(this.getMessage("menu.list").split(","));
		final List<Menu> menus = new ArrayList<>();
		for (final String menuKey : menuKeys) {
			final String prefix = "menu." + menuKey.trim();
			final String title = this.getMessage(prefix + ".title");
			final String url = this.getMessage(prefix + ".url");
			menus.add(new Menu(title, url));
		}
		mav.getModel().put("menus", menus);
		return mav;
	}
}
