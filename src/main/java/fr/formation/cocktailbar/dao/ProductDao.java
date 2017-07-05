package fr.formation.cocktailbar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.cocktailbar.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	List<Product> findAllByNameContains(final String search);
	
}
