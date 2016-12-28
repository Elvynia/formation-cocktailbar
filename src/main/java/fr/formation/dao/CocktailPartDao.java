package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.entity.CocktailPart;

public interface CocktailPartDao extends JpaRepository<CocktailPart, Integer> {

	void deleteAllByCocktailId(Integer cocktailId);

	List<CocktailPart> findAllByCocktailId(Integer cocktailId);

}
