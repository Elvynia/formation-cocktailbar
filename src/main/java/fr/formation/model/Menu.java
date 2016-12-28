package fr.formation.model;

/**
 * POJO permettant de dynamiser l'affichage du menu dans la page JSP d'index qui
 * liste les différents menus.
 *
 * @author hb-asus
 *
 */
public class Menu {

	final private String title;

	final private String url;

	public Menu(final String title, final String url) {
		this.title = title;
		this.url = url;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}

}
