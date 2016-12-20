package fr.formation.entity;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Cocktail implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotNull
	@Pattern(regexp = "[^/:;+=@]+")
	private String name;

	@NotNull
	@Min(0)
	private Float price;

	private boolean withAlcohol;

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
		final Cocktail other = (Cocktail) obj;
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

	/**
	 * @return the price
	 */
	public Float getPrice() {
		return this.price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.id == null ? 0 : this.id.hashCode());
		return result;
	}

	/**
	 * @return the withAlcohol
	 */
	public boolean isWithAlcohol() {
		return this.withAlcohol;
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

	/**
	 * @param price the price to set
	 */
	public void setPrice(final Float price) {
		this.price = price;
	}

	/**
	 * @param withAlcohol the withAlcohol to set
	 */
	public void setWithAlcohol(final boolean withAlcohol) {
		this.withAlcohol = withAlcohol;
	}

}
