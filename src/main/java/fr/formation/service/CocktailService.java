package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.CocktailDao;
import fr.formation.dao.CocktailPartDao;
import fr.formation.dao.IngredientDao;
import fr.formation.entity.Cocktail;
import fr.formation.entity.CocktailPart;

@Service
public class CocktailService {

	@Autowired
	private CocktailPartDao cocktailPartDao;

	@Autowired
	private CocktailDao dao;

	@Autowired
	private IngredientDao ingredientDao;

	@Transactional
	public void addCocktailPart(final Integer cocktailId,
			final Integer ingredientId, final Integer quantity) {
		final CocktailPart cocktailPart = new CocktailPart();
		cocktailPart.setCocktail(this.dao.findOne(cocktailId));
		cocktailPart.setIngredient(this.ingredientDao.findOne(ingredientId));
		cocktailPart.setQuantity(quantity);

		this.cocktailPartDao.save(cocktailPart);
	}

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

	public List<CocktailPart> getCocktailParts() {
		return this.cocktailPartDao.findAll();
	}

	@Transactional
	public void update(final Cocktail cocktail) {
		this.dao.save(cocktail);
	}
}
