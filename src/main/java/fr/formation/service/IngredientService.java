package fr.formation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import fr.formation.dao.IngredientDao;
import fr.formation.entity.CocktailPart;
import fr.formation.entity.Ingredient;

/**
 * Service permettant de gérer les échanges avec la couche DAO pour modifier les
 * ingrédients en base de données.
 *
 * @author hb-asus
 *
 */
@Service
public class IngredientService {

	@Autowired
	private IngredientDao dao;

	@Transactional
	public void create(final Ingredient ingredient) {
		this.dao.save(ingredient);
	}

	public void delete(final Integer id) {
		this.dao.delete(id);
	}

	public Ingredient get(final Integer ingredientId) {
		return this.dao.findOne(ingredientId);
	}

	public List<Ingredient> getAll() {
		return this.dao.findAll();
	}

	public List<Ingredient> getAllByCocktail(
			final List<CocktailPart> cocktailParts) {
		List<Ingredient> results = null;
		if (CollectionUtils.isEmpty(cocktailParts)) {
			results = this.getAll();
		} else {
			final List<Integer> ingredientIds = cocktailParts.stream()
					.map((final CocktailPart cocktailPart) -> cocktailPart
							.getIngredient().getId())
					.collect(Collectors.toList());
			results = this.dao.findAllByIdNotIn(ingredientIds);
		}
		return results;
	}
}
