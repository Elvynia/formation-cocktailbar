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

/**
 * Controleur appelé dès qu'une URL commence par '/ingredients'. Ses méthodes
 * permettent de gérer l'affichage de la liste des ingrédients ainsi que de
 * gérer le formulaire d'ajout d'un nouvel ingrédient.
 *
 * @author hb-asus
 *
 */
@Controller
@RequestMapping("/ingredients")
public class IngredientController {

	/**
	 * Injection du service permettant de gérer l'accès des ingrédients en base.
	 */
	@Autowired
	private IngredientService service;

	/**
	 * Méthode permettant de rediriger vers la page d'ajout d'un ingrédient.
	 *
	 * @return ModelAndView l'objet Spring avec le nom de vue correspondant à
	 *         une page JSP.
	 */
	@RequestMapping("/add")
	public ModelAndView add() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("addIngredient");
		return mav;
	}

	/**
	 * Méthode permettant de supprimer un ingrédient. Il s'agit d'une requête
	 * HTTP GET avec l'identifiant de l'ingrédient à supprimer dans la dernière
	 * partie de l'URL. Les crochets dans le request mapping servent à définir
	 * un nom de variable. Ce nom est ensuite réutilisé en paramètre de la
	 * méthode pour récupérer l'identifiant.
	 *
	 * @param id l'identifiant de l'ingrédient récupéré de l'URL.
	 * @return String une URL de redirection vers la page d'ajout d'un cocktail.
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable final Integer id) {
		this.service.delete(id);
		return "redirect:/ingredients.html";
	}

	/**
	 * Méthode permettant de rediriger vers la page de liste des ingrédients. On
	 * ajoute la liste des ingrédients récupérés du service dans le Model afin
	 * que la liste soit utilisable depuis la page JSP.
	 *
	 * @return ModelAndView l'objet Spring avec le nom de vue correspondant à
	 *         une page JSP.
	 */
	@RequestMapping
	public ModelAndView list() {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("ingredients");
		mav.addObject("ingredients", this.service.getAll());
		return mav;
	}

	/**
	 * Méthode de confirmation d'ajout d'un nouvel ingrédient.
	 *
	 * @param request l'objet de requête HTTP permettant de récupérer
	 *            manuellement les valeurs des paramètres envoyés par le client.
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String newIngredient(final HttpServletRequest request) {
		final String name = request.getParameter("name");
		final Integer state = Integer.parseInt(request.getParameter("state"));
		this.service.create(new Ingredient(name, state));
		return "redirect:/ingredients/add.html";
	}

	/**
	 * Méthode (de démonstration, non utilisée) de confirmation d'ajout d'un
	 * nouvel ingrédient. On récupère grâce aux annotations RequestParam les
	 * valeurs des paramètres de la requête HTTP POST.
	 *
	 * @param name le nom de l'ingrédient.
	 * @param state l'état de l'ingrédient.
	 * @return String une URL de redirection vers la page d'ajout d'un cocktail.
	 */
	@RequestMapping(value = "/add2", method = RequestMethod.POST)
	public String newIngredient2(@RequestParam final String name,
			@RequestParam final Integer state) {
		this.service.create(new Ingredient(name, state));
		return "redirect:/ingredients/add.html";
	}
}
