package armee.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import armee.entities.Composition;
import armee.entities.Partie;

public interface CompositionRepository extends JpaRepository<Composition, Long> {

	Optional<Composition> findCompositionByParties(Partie partie);
}
