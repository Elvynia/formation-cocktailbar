package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.entity.Cocktail;

/**
 * Repository permettant de gérer l'interaction avec la base de données pour les
 * objets Cocktail.
 *
 * @author hb-asus
 *
 */
public interface CocktailDao extends JpaRepository<Cocktail, Integer> {

}
