package fr.elvynia.formation.cocktailbar.presentation;

import java.io.Serializable;

public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;

	private String url;

	public Menu() {
	}

	public Menu(final String title, final String url) {
		this.title = title;
		this.url = url;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
