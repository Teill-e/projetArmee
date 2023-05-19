package armee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import armee.entities.Compte;
import armee.entities.Partie;
import armee.exceptions.PartieException;
import armee.repositories.CompositionRepository;
import armee.repositories.PartieRepository;



@Service
public class PartieService {
	
	@Autowired
	private PartieRepository partieRepo;
	
	
	@Autowired
	private CompositionRepository compositionRepo;
	
	
	private void checkPartie(Partie partie) {
		if (partie == null) {
			throw new PartieException("Partie null");
		}
		if (partie.getDate() == null || partie.getJoueur() == null) {
			throw new PartieException("informations manquantes");
		}
	}

	private void checkId(Long id) {
		if (id == null) {
			throw new PartieException("id null");
		}
	}

	public Partie create(Partie partie) {
		checkPartie(partie);
		return partieRepo.save(partie);
	}

	public Partie update(Partie partie) {
		Partie partieEnBase = getById(partie.getId());
		checkPartie(partie);
		partieEnBase.setDate(partie.getDate());
		partieEnBase.setFin(partie.isFin());
		partieEnBase.setJoueur(partie.getJoueur());
		partieEnBase.setCompoJoueur(partie.getCompoJoueur());
		partieEnBase.setCompoIA(partie.getCompoIA());
		return partieRepo.save(partieEnBase);
	}

	public Partie getById(Long id) {
		checkId(id);
		return partieRepo.findById(id).orElseThrow(() -> {
			throw new PartieException("id inconnu");
		});

}
	public List<Partie> getAll() {
		return partieRepo.findAll();
	}


	public void delete(Partie partie) {
		delete(partie.getId());
	}
	
	public void delete(Long id) {
		Partie partieEnBase = getById(id);
		compositionRepo.deleteByParties(partieEnBase);
		partieRepo.delete(partieEnBase);		
	}

	
}
