package armee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import armee.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

}
