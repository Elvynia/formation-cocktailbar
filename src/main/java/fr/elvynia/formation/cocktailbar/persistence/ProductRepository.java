package fr.elvynia.formation.cocktailbar.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.elvynia.formation.cocktailbar.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
