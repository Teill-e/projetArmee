package armee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import armee.entities.Arme;
import armee.entities.Unite;
import armee.exceptions.ArmeException;
import armee.exceptions.CompositionException;
import armee.repositories.ArmeRepository;
import armee.repositories.UniteRepository;

@Service
public class ArmeService {

	@Autowired
	private ArmeRepository armeRepo;
	
	@Autowired
	private UniteRepository uniteRepo;
	
	private void checkArme(Arme arme) {
		if (arme == null) {
			throw new ArmeException("arme null");
		}
		if (arme.getTypeA() == null) {
			throw new ArmeException("définir type arme");
		}
	}
	
	private void checkId(Long id) {
		if(id == null) {
			throw new ArmeException("id null");
		}
	}
	
	public Arme getById(Long id) {
		checkId(id);
		return armeRepo.findById(id).orElseThrow(() -> {
			throw new ArmeException("id inconnu");
		});		
	}
	
	public Arme create(Arme arme) {
		checkArme(arme);
		return armeRepo.save(arme);
	}
	
	public Arme update(Arme arme) {
		Arme armeEnBase = getById(arme.getId());
		checkArme(arme);
		armeEnBase.setTypeA(arme.getTypeA());
		armeEnBase.setUniteArmes(arme.getUniteArmes());
		return armeRepo.save(armeEnBase);
	}
	
	public List<Arme> getAll(){
		return armeRepo.findAll();
	}
	
	public Optional<Arme> findByUnite(Unite unite){
		return Optional.of(armeRepo.findByUniteArmes(unite).orElseThrow(() -> {
			throw new ArmeException("Pas d'arme pour cette unite");
		}));
	}
	
	public void delete(Arme arme) {
	armeRepo.delete(arme);	
	}
	
}

