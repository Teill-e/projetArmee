package armee.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import armee.entities.Arme;
import armee.entities.Armee;
import armee.entities.Composition;
import armee.entities.Unite;

public interface UniteRepository extends JpaRepository<Unite, Long> {
	List<Unite> findByComposition (Composition composition);
	
	List<Unite> findByArme (Arme arme);

	@Query("update Unite u set u.armee=null where u.armee=:armee")
	@Transactional
	@Modifying
	void setArmeeToNull(@Param("armee") Armee armeeEnBase);

	@Query("update Unite u set u.composition=null where u.composition=:composition")
	@Transactional
	@Modifying
	void setCompositionToNull(@Param("composition") Composition compositionEnBase);
}
