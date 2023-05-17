package armee.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import armee.entities.Joueur;
import armee.entities.Partie;

public interface PartieRepository extends JpaRepository<Partie, Long> {
	List<Partie> findByDate(LocalDate date);
	
	List<Partie> findByJoueur(Joueur joueur);
}
