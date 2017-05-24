package fr.formation.cocktailbar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.cocktailbar.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
