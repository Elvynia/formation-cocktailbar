package fr.elvynia.formation.cocktailbar.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import fr.elvynia.formation.cocktailbar.entity.Product;
import fr.elvynia.formation.cocktailbar.persistence.ProductRepository;

@Service
public class ProductService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> getAll() {
		return this.productRepo.findAll();
	}
	
	public boolean create(Product product) {
		boolean created = false;
		if (product.getId() == null) {
			try {
				this.productRepo.save(product);
				created = true;
			} catch (DataAccessException e) {
				LOGGER.error("Impossible de créer le produit en BDD.", e);
			}
		}
		return created;
	}
	
	public boolean update(Product product) {
		boolean update = false;
		if (product.getId() != null) {
			try {
				this.productRepo.save(product);
				update = true;
			} catch (DataAccessException e) {
				LOGGER.error("Impossible de mettre à jour le produit en BDD.", e);
			}
		}
		return update;
	}
	
	public boolean delete(Integer id) {
		boolean deleted = false;
		try {
			this.productRepo.deleteById(id);
		} catch (DataAccessException e) {
			LOGGER.error("Impossible de supprimer le produit en BDD.", e);
		}
		return deleted;
	}

	public Product read(Integer id) {
		return this.productRepo.getOne(id);
	}
}
