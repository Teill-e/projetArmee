package armee.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import armee.entities.Joueur;
import armee.entities.Partie;


public interface JoueurRepository extends JpaRepository<Joueur, Long> {
	
	@Transactional
	@Modifying
	void deleteByListeParties(Partie listeParties);
}
