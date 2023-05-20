package armee.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import armee.entities.Composition;
import armee.entities.Joueur;
import armee.entities.Partie;

public interface CompositionRepository extends JpaRepository<Composition, Long> {

	Optional<Composition> findByParties(Partie parties);
	
	@Transactional
	@Modifying
	void deleteByParties(Partie parties);
}
