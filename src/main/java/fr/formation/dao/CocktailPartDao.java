package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.entity.CocktailPart;

/**
 * Repository permettant de gérer l'interaction avec la base de données pour les
 * objets CocktailPart.
 *
 * @author hb-asus
 *
 */
public interface CocktailPartDao extends JpaRepository<CocktailPart, Integer> {

	void deleteAllByCocktailId(Integer cocktailId);

	List<CocktailPart> findAllByCocktailId(Integer cocktailId);

}
