package fr.formation.entity;

import java.io.Serializable;

public class Ingredient implements Serializable {

	private static final long serialVersionUID = 1L;

	private int etat;

	private Integer id;

	private String name;

	public Ingredient() {
	}

	public Ingredient(final String name, final int etat) {
		this.name = name;
		this.etat = etat;
	}

	/**
	 * @return the etat
	 */
	public int getEtat() {
		return this.etat;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(final int etat) {
		this.etat = etat;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
