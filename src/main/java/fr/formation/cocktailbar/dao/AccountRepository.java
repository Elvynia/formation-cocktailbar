package fr.formation.cocktailbar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.cocktailbar.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	Account findOneByUsername(final String username);
}
