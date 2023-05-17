package armee.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import armee.entities.Arme;
import armee.entities.Unite;

public interface ArmeRepository extends JpaRepository<Arme, Long> {
	Optional<Arme> findArmeByUniteArmes (Unite unite);
}
