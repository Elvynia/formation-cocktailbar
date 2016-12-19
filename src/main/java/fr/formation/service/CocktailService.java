package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.CocktailDao;
import fr.formation.dao.CocktailPartDao;
import fr.formation.entity.Cocktail;
import fr.formation.entity.CocktailPart;

@Service
public class CocktailService {

	@Autowired
	CocktailPartDao cocktailPartDao;

	@Autowired
	private CocktailDao dao;

	@Transactional
	public void create(final Cocktail ingredient) {
		this.dao.save(ingredient);
	}

	public List<Cocktail> getAll() {
		return this.dao.findAll();
	}

	public List<CocktailPart> getCocktailParts() {
		return this.cocktailPartDao.findAll();
	}
}
