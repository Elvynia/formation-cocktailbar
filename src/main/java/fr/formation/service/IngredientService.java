package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.IngredientDao;
import fr.formation.entity.Ingredient;

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

	public List<Ingredient> getAll() {
		return this.dao.findAll();
	}
}
