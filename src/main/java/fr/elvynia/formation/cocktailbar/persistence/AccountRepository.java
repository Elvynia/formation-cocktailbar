package fr.elvynia.formation.cocktailbar.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.elvynia.formation.cocktailbar.entity.Account;

@Repository
public interface AccountRepository
		extends JpaRepository<Account, Integer> {

	Account findOneByUsername(final String username);
}
