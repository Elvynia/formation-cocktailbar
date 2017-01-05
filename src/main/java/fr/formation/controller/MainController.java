package fr.formation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.model.Menu;
import fr.formation.service.SearchService;

/**
 * Controleur principal permettant de gérer l'URL '/' (qui implicitement donne
 * '/index.html') et d'afficher la page de menu de l'application.
 *
 * @author hb-asus
 *
 */
@Controller
public class MainController {

	/**
	 * Injection du bean de messages défini dans applicationContext.xml.
	 */
	@Autowired
	private MessageSource messages;

	@Autowired
	private SearchService searchService;

	/**
	 * Méthode privée permettant de récupérer un message plus facilement
	 * (abstraction des paramètres inutilisés).
	 *
	 * @param key la clé du message.
	 * @return String le message demandé.
	 */
	private String getMessage(final String key) {
		return this.messages.getMessage(key, null, null);
	}

	/**
	 * Méthode permettant de charger la page JSP principale de l'application. On
	 * charge une liste d'objets Menu dans le Model pour pouvoir l'utiliser dans
	 * la JSP.
	 *
	 * @return
	 */
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

	@RequestMapping("/search")
	public ModelAndView search() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("search");
		return mav;
	}

	@RequestMapping("/search/name")
	public String searchResults(@RequestParam final String search,
			final Model model) {
		model.addAttribute("results", this.searchService.searchByName(search));
		return "forward:/search.html";
	}
}
