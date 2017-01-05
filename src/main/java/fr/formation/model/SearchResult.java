package fr.formation.model;

import fr.formation.entity.Cocktail;

public interface SearchResult {

	public default String getCategory() {
		if (Cocktail.class == this.getClass()) {
			return "Cocktail";
		} else {
			return "Ingrédient";
		}
	}

	public Integer getId();

	public String getName();
}
