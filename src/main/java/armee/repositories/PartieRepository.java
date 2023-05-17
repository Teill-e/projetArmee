package armee.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import armee.entities.Joueur;
import armee.entities.Partie;

public interface PartieRepository extends JpaRepository<Partie, Long> {
	//SELECT p FROM Partie p WHERE p.date = :datePartie
	@Query("SELECT p FROM Partie p WHERE p.date = :datePartie")
	Optional<Partie> findPartieByDate(@Param("datePartie")LocalDate date);
	
	@Query("SELECT p FROM Partie p WHERE p.joueur = :joueur")
	Optional<Partie> findPartieByJoueur(@Param("joueur")Joueur joueur);
}
