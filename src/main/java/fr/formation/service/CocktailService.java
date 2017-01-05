package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.CocktailDao;
import fr.formation.dao.CocktailPartDao;
import fr.formation.entity.Cocktail;
import fr.formation.entity.CocktailPart;

/**
 * Service permettant de gérer les échanges avec la couche DAO pour modifier les
 * cocktails en base de données.
 *
 * @author hb-asus
 *
 */
@Service
public class CocktailService {

	/**
	 * DAO des {@link CocktailPart} en membre privé du service pour pouvoir
	 * l'utiliser dans les différentes méthodes.
	 */
	@Autowired
	private CocktailPartDao cocktailPartDao;

	/**
	 * DAO des {@link Cocktail} en membre privé du service pour pouvoir
	 * l'utiliser dans les différentes méthodes.
	 */
	@Autowired
	private CocktailDao dao;

	/**
	 * Gère l'ajout d'un cocktail en base de données grâce au DAO.
	 *
	 * @param cocktail
	 */
	@Transactional
	public void create(final Cocktail cocktail) {
		this.dao.save(cocktail);
	}

	public Cocktail get(final Integer id) {
		return this.dao.findOne(id);
	}

	public List<Cocktail> getAll() {
		return this.dao.findAll();
	}

	public List<CocktailPart> getCocktailParts(final Integer cocktailId) {
		return this.cocktailPartDao.findAllByCocktailId(cocktailId);
	}

	@Transactional
	public void update(final Cocktail cocktail) {
		this.dao.save(cocktail);
	}

	@Transactional
	public void updateCocktailParts(final Integer cocktailId,
			final List<CocktailPart> cocktailParts) {
		final List<CocktailPart> dbParts = this.cocktailPartDao
				.findAllByCocktailId(cocktailId);
		final List<CocktailPart> toUpdate = new ArrayList<>(cocktailParts);
		final List<CocktailPart> toAdd = new ArrayList<>(cocktailParts);
		final List<CocktailPart> toDelete = new ArrayList<>(dbParts);

		// Elements en commun : mettre à jour.
		toUpdate.retainAll(dbParts);
		toUpdate.forEach((part) -> {
			final CocktailPart dbPart = dbParts.get(dbParts.indexOf(part));
			dbPart.setQuantity(part.getQuantity());
			this.cocktailPartDao.save(dbPart);
		});
		// Elements seulement dans cocktailParts : ajouter.
		toAdd.removeAll(dbParts);
		toAdd.forEach((part) -> this.cocktailPartDao.save(part));
		// Elements seulement dans dbParts : supprimer.
		toDelete.removeAll(cocktailParts);
		toDelete.forEach((part) -> this.cocktailPartDao.delete(part));
	}
}
