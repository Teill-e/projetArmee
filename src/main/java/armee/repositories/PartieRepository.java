package armee.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import armee.entities.Composition;
import armee.entities.Joueur;
import armee.entities.Partie;

public interface PartieRepository extends JpaRepository<Partie, Long> {
	List<Partie> findByDate(LocalDate date);
	
	List<Partie> findByJoueur(Joueur joueur);
	
	
	@Transactional
	@Modifying
	void deleteByJoueur(Joueur joueur);
	
	@Transactional
	@Modifying
	void deleteByCompoJoueur(Composition compoJoueur);
	
}
