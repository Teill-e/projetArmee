package armee.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import armee.entities.Composition;
import armee.entities.Unite;

public interface UniteRepository extends JpaRepository<Unite, Long> {
	Optional<Unite> findUniteByComposition (Composition composition);
}
