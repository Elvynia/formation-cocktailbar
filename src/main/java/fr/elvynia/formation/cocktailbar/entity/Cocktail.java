package fr.elvynia.formation.cocktailbar.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "COCKTAIL")
public class Cocktail implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	private String name;

	@Min(value = 0, message = "erreur min")
	private Float price;

	private Boolean withAlcohol;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Cocktail)) {
			return false;
		}
		Cocktail other = (Cocktail) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

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

	/**
	 * Affichage d'un cocktail en chaine de caractères.
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("{");
		sb.append(" id=").append(this.id != null ? this.id : "null");
		sb.append(", name=").append(this.name != null ? this.name : "null");
		sb.append(", price=").append(this.price != null ? this.price : "null");
		sb.append(", withAlcohol=").append(this.withAlcohol != null ? this.withAlcohol : "null");
		sb.append(" }");
		return sb.toString();
	}
}
