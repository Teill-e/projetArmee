package armee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import armee.entities.Arme;
import armee.entities.Composition;
import armee.entities.Compte;
import armee.entities.Unite;
import armee.exceptions.CompositionException;
import armee.exceptions.UniteException;
import armee.repositories.ArmeRepository;
import armee.repositories.CompositionRepository;
import armee.repositories.UniteRepository;



@Service
public class UniteService {
	
	@Autowired
	private UniteRepository uniteRepo;
	
	
	@Autowired
	private ArmeRepository armeRepo;
	
	
	private void checkUnite(Unite unite) {
		if (unite == null) {
			throw new UniteException("Unite null");
		}
		if (unite.getPrix() == 0 || unite.getArmee() == null || unite.getArmee() == null) {
			throw new UniteException("informations manquantes");
		}
	}

	private void checkId(Long id) {
		if (id == null) {
			throw new UniteException("id null");
		}
	}

	public Unite create(Unite unite) {
		checkUnite(unite);
		return uniteRepo.save(unite);
	}

	public Unite update(Unite unite) {
		Unite uniteEnBase = getById(unite.getId());
		checkUnite(unite);
		uniteEnBase.setArmee(unite.getArmee());
		uniteEnBase.setArmes(unite.getArmes());
		uniteEnBase.setComposition(unite.getComposition());
		uniteEnBase.setPrix(unite.getPrix());
		return uniteRepo.save(uniteEnBase);
	}

	public Unite getById(Long id) {
		checkId(id);
		return uniteRepo.findById(id).orElseThrow(() -> {
			throw new UniteException("id inconnu");
		});

}
	public List<Unite> getAll() {
		return uniteRepo.findAll();
	}
	
	public Unite findByComposition(Composition composition){
		return uniteRepo.findByComposition(composition).orElseThrow(() -> {
			throw new UniteException("Pas de composition pour cette unite");
		});
	}
	
	public Unite findByArme(Arme arme){
		return uniteRepo.findByArmes(arme).orElseThrow(() -> {
			throw new UniteException("Pas d'arme pour cette unite");
		});
	}

	public void delete(Unite unite) {
		delete(unite.getId());
	}
	
	public void delete(Long id) {
		Unite uniteEnBase = getById(id);
		armeRepo.deleteByUniteArmes(uniteEnBase);
		uniteRepo.delete(uniteEnBase);		
	}

	
}
