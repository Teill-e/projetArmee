package armee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import armee.entities.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

}
