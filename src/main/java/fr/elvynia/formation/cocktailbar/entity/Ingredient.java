package fr.elvynia.formation.cocktailbar.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INGREDIENT")
public class Ingredient implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Float quantity;

	@OneToOne
	private Cocktail cocktail;

	@OneToOne
	private Product product;

	public Ingredient() {
	}

	public Ingredient(final Cocktail cocktail, final Product product) {
		this.cocktail = cocktail;
		this.product = product;
	}

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
		if (!(obj instanceof Ingredient)) {
			return false;
		}
		Ingredient other = (Ingredient) obj;
		if (id == null) {
			// Comparaison par identifiant produit et cocktail.
			if (cocktail != null && product != null) {
				if (other.cocktail == null || other.product == null) {
					return false;
				} else if (!cocktail.getId().equals(other.cocktail.getId())) {
					return false;
				} else if (!product.getId().equals(other.product.getId())) {
					return false;
				}
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
	 * @return the quantity
	 */
	public Float getQuantity() {
		return quantity;
	}

	/**
	 * @return the cocktail
	 */
	public Cocktail getCocktail() {
		return cocktail;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param cocktail
	 *            the cocktail to set
	 */
	public void setCocktail(Cocktail cocktail) {
		this.cocktail = cocktail;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("{ id=");
		sb.append(this.id != null ? this.id : "null");
		sb.append(", cocktailId=").append(this.cocktail != null ? this.cocktail.getId() : "null");
		sb.append(", productId=").append(this.product != null ? this.product.getId() : "null");
		sb.append(", quantity=").append(this.quantity != null ? this.quantity : "null");
		sb.append(" }");
		return sb.toString();
	}
}
