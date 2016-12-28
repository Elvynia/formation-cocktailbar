package fr.formation.entity;

import java.io.Serializable;

/**
 * POJO représentant une entité de la base de données dans l'ORM et lié avec la
 * table 'ingredient'.
 *
 * @author hb-asus
 *
 */
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

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Ingredient other = (Ingredient) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the etat
	 */
	public int getEtat() {
		return this.etat;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.id == null ? 0 : this.id.hashCode());
		return result;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(final int etat) {
		this.etat = etat;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

}
