package fr.formation.entity;

import java.io.Serializable;

public class CocktailPart implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cocktail cocktail;

	private Integer id;

	private Ingredient ingredient;

	private Integer quantity;

	/**
	 * @return the cocktail
	 */
	public Cocktail getCocktail() {
		return this.cocktail;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return this.quantity;
	}

	/**
	 * @param cocktail the cocktail to set
	 */
	public void setCocktail(final Cocktail cocktail) {
		this.cocktail = cocktail;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(final Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the ingredient
	 */
	public Ingredient getIngredient() {
		return ingredient;
	}

	/**
	 * @param ingredient the ingredient to set
	 */
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
}
