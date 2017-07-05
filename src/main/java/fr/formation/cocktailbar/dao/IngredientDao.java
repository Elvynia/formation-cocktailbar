package fr.formation.cocktailbar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.cocktailbar.entity.Ingredient;

public interface IngredientDao extends JpaRepository<Ingredient, Integer> {

	List<Ingredient> findAllByCocktailId(final Integer cocktailId);
}
