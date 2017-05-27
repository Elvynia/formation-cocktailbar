package fr.formation.cocktailbar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.cocktailbar.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

	public List<Ingredient> findAllByCocktailId(final Integer cocktailId);

	@Transactional
	public void deleteByCocktailId(final Integer cocktailId);
}
