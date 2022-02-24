package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	Utilisateur findByUsername(String username);

	@Query(value = "SELECT count(*) FROM Utilisateur", nativeQuery = true)
	int nbrUtilisateurs();
}
