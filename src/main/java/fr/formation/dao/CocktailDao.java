package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.entity.Cocktail;

public interface CocktailDao extends JpaRepository<Cocktail, Integer> {

}
