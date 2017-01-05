package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.entity.Ingredient;

/**
 * Repository permettant de gérer l'interaction avec la base de données pour les
 * objets Ingredient.
 *
 * @author hb-asus
 *
 */
public interface IngredientDao extends JpaRepository<Ingredient, Integer> {

	List<Ingredient> findAllByIdNotIn(final List<Integer> ids);

	List<Ingredient> findAllByNameContains(final String search);
}
