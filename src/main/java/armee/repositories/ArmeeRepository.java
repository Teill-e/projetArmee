package armee.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import armee.entities.Armee;



public interface ArmeeRepository extends JpaRepository<Armee, Long> {

	
	
}