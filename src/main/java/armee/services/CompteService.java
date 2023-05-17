package armee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import armee.entities.Compte;
import armee.exceptions.CompteException;
import armee.repositories.CompteRepository;
import armee.repositories.UniteRepository;


public class CompteService {
	@Autowired
	private CompteRepository compteRepo;
	
	@Autowired
	private UniteRepository uniteRepo;
	
	
	private void checkCompte(Compte compte) {
		if (compte == null) {
			throw new CompteException("compte null");
		}
		if (compte.getUnites() == null || compte.getParties() == null) {
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
		compteEnBase.setUnites(compte.getUnites());
		compteEnBase.setParties(compte.getParties());
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
		uniteRepo.setCompteToNull(CompteEnBase);
		compteRepo.delete(CompteEnBase);
	}
}
