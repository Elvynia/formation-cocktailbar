package fr.formation.cocktailbar.entity;

import java.io.Serializable;

public class Cocktail implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private Float price;

	private Boolean withAlcohol;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * @return the withAlcohol
	 */
	public Boolean getWithAlcohol() {
		return withAlcohol;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * @param withAlcohol
	 *            the withAlcohol to set
	 */
	public void setWithAlcohol(Boolean withAlcohol) {
		this.withAlcohol = withAlcohol;
	}

}
