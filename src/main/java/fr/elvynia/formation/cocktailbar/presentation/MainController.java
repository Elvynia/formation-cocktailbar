package fr.elvynia.formation.cocktailbar.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	private static final String KEY_SUFFIX_TITLE = ".title";
	private static final String KEY_SUFFIX_URL = ".url";

	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private MessageSource messageSource;

	@RequestMapping({ "/", "/index" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		final String menus = this.getMessage("menus");
		MainController.LOGGER.debug("Valeur associé à la clé 'menus' : {}", menus);
		final List<Menu> menuList = new ArrayList<>();
		if (menus != null && !menus.isEmpty()) {
			for (final String menu : menus.split(",")) {
				final String title = this.getMessage(menu.concat(MainController.KEY_SUFFIX_TITLE));
				final String url = this.getMessage(menu.concat(MainController.KEY_SUFFIX_URL));
				menuList.add(new Menu(title, url));
			}
		}
		mav.getModel().put("menuList", menuList);
		return mav;
	}
	
	private String getMessage(final String key) {
		return this.messageSource.getMessage(key, null, Locale.getDefault());
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
}
