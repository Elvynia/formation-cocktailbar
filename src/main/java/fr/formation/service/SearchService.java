package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.CocktailDao;
import fr.formation.dao.IngredientDao;
import fr.formation.model.SearchResult;

@Service
public class SearchService {

	@Autowired
	private CocktailDao cocktailDao;

	@Autowired
	private IngredientDao ingredientDao;

	public List<SearchResult> searchByName(final String name) {
		final List<SearchResult> results = new ArrayList<>();
		results.addAll(this.cocktailDao.findAllByNameContains(name));
		results.addAll(this.ingredientDao.findAllByNameContains(name));
		return results;
	}
}
