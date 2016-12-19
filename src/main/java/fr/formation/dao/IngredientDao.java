package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.entity.Ingredient;

public interface IngredientDao extends JpaRepository<Ingredient, Integer> {

}
