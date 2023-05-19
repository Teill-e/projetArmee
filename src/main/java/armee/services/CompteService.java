package armee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import armee.entities.Admin;
import armee.entities.Compte;
import armee.entities.Joueur;
import armee.exceptions.CompteException;
import armee.repositories.AdminRepository;
import armee.repositories.CompteRepository;
import armee.repositories.JoueurRepository;
import armee.repositories.PartieRepository;

@Service
public class CompteService {
	@Autowired
	private CompteRepository compteRepo;
	
	
	
	@Autowired
	private JoueurRepository joueurRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private PartieRepository partieRepo;
	
	
	
	
	
	private void checkCompte(Compte compte) {
		if (compte == null) {
			throw new CompteException("compte null");
		}
		if (compte.getLogin() == null || compte.getPassword() == null) {
			throw new CompteException("informations manquantes");
		}
	}
	
	private void checkId(Long id) {
		if(id == null) {
			throw new CompteException("id null");
		}
	}
	
	public Compte getById(Long id) {
		checkId(id);
		return compteRepo.findById(id).orElseThrow(() -> {
			throw new CompteException("id inconnu");
		});		
	}
	
	public Compte create(Compte compte) {
		checkCompte(compte);
		return compteRepo.save(compte);
	}
	
	public Compte update(Compte compte) {
		Compte compteEnBase = getById(compte.getId());
		checkCompte(compte);
		compteEnBase.setLogin(compte.getLogin());
		compteEnBase.setPassword(compte.getPassword());
		return compteRepo.save(compteEnBase);
	}
	
	public List<Compte> getAll(){
		return compteRepo.findAll();
	}
	
	public void delete(Compte compte) {
		delete(compte.getId());
	}
	
	public void delete(Long id) {
		Compte CompteEnBase = getById(id);
		if(CompteEnBase instanceof Admin) { 
			deleteAdmin(CompteEnBase);
			}
		
		if(CompteEnBase instanceof Joueur) {
			deleteJoueur(CompteEnBase);
		}
	}
	
	
	public void deleteJoueur(Compte joueur) {
		partieRepo.deleteByJoueur((Joueur) joueur);
		joueurRepo.delete((Joueur) joueur);
		
		
	}
	
	public void deleteAdmin(Compte admin) {
		
		adminRepo.delete((Admin) admin);
		
	}
	
	
}







