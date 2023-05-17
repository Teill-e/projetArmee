package armee.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import armee.entities.Admin;
import armee.entities.Joueur;


public interface AdminRepository extends JpaRepository<Admin, Long> {

}
