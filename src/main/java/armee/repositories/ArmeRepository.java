package armee.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import armee.entities.Arme;
import armee.entities.Partie;
import armee.entities.Unite;

public interface ArmeRepository extends JpaRepository<Arme, Long> {
	Optional<Arme> findByUniteArmes (Unite unite);

	
	@Transactional
	@Modifying
	void deleteByUniteArmes(Unite uniteArmes);
}
