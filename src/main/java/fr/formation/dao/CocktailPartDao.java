package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.entity.CocktailPart;

public interface CocktailPartDao extends JpaRepository<CocktailPart, Integer> {

}
