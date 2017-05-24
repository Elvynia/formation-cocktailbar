package fr.formation.cocktailbar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.cocktailbar.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

}
