package armee.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;


import armee.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	
	
	
	

}
