package projetArmee;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import armee.config.JPAconfig;
import armee.entities.Joueur;
import armee.entities.Partie;
import armee.repositories.AdminRepository;
import armee.repositories.ArmeRepository;
import armee.repositories.ArmeeRepository;
import armee.repositories.CompositionRepository;
import armee.repositories.JoueurRepository;
import armee.repositories.PartieRepository;
import armee.repositories.UniteRepository;
import armee.services.JoueurService;
import armee.services.PartieService;

@SpringJUnitConfig(JPAconfig.class)
public class RepositoriesTest {

	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	ArmeeRepository armeeRepo;
	
	@Autowired
	ArmeRepository armeRepo;
	
	@Autowired
	JoueurRepository joueurRepo;
	
	@Autowired
	PartieRepository partieRepo;
	
	@Autowired
	CompositionRepository compoRepo;
	
	@Autowired
	UniteRepository uniteRepo;
	
	@Autowired
	JoueurService jrs;
	
	@Autowired 
	PartieService ps;
	
	/*@Test
	void testAdmin() {
		Admin admin = new Admin("a", "123");
		adminRepo.save(admin);
		assertNotNull(admin.getId());
		
		Optional<Admin> opt = adminRepo.findById(admin.getId());
		if(opt.isPresent()) {
			assertTrue(opt.get() instanceof Admin);
		}
	}
		
	@Test
	void testArmee() {
		ArmeeAir armee = new ArmeeAir(100, Pays.Australie);
		
		armeeRepo.save(armee);
		assertNotNull(armee.getId());
		
		Optional<Armee> opt = armeeRepo.findById(armee.getId());
		if(opt.isPresent()) {
			assertTrue(opt.get() instanceof Armee);
		}
	}
	
	@Test
	void testArme() {
		Arme arme = new Arme(TypeA.couteau);
		armeRepo.save(arme);
		ArmeeAir armee = new ArmeeAir();
		armeeRepo.save(armee);

		Set<Arme> armes = new HashSet<>();
		armes.add(arme);
		Unite unite = new Unite(armes, 0, armee);
		uniteRepo.save(unite);
		assertNotNull(arme.getId());
		
		Optional<Arme> opt = armeRepo.findByUniteArmes(unite);
		if(opt.isPresent()) {
			assertTrue(opt.get() instanceof Arme);
		}
	}
	
	@Test
	void testJoueur() {
		Joueur joueur = new Joueur("b", "123");
		
		joueurRepo.save(joueur);
		assertNotNull(joueur.getId());
		
		Optional<Joueur> opt = joueurRepo.findById(joueur.getId());
		if(opt.isPresent()) {
			assertTrue(opt.get() instanceof Joueur);
		}
	}
	*/
	/*@Test
	void testPartie() {
		Joueur joueur = new Joueur("c", "123");
		joueurRepo.save(joueur);
		Partie partie = new Partie(LocalDate.now(), false, joueur, null, null);
		
		partieRepo.save(partie);
		assertNotNull(partie.getId());
		List<Partie> opt = partieRepo.findByJoueur(joueur);
		
		for(Partie p : opt) 
		{
			System.out.println(p.getId());
		}
		
		
		//ps.delete(partie);
		//System.out.println("Delete");
		jrs.delete(joueur);
		System.out.println("Delete");
		 opt = partieRepo.findByJoueur(joueur);
		for(Partie p : opt) 
		{
			System.out.println(p.getId());
		}
		
		
	}
	/*
	@Test
	void testComposition() {
		Joueur joueur = new Joueur("b", "123");
		joueurRepo.save(joueur);
				
		Composition compo = new Composition();
		compoRepo.save(compo);
		
		Partie partie = new Partie(LocalDate.now(), false, joueur, compo, null);
		partieRepo.save(partie);
		assertNotNull(compo.getId());
		
		List<Composition> opt = compoRepo.findByParties(partie);
		
	}
	
	@Test
	void testUnite() {
		Unite unite = new Unite();
		uniteRepo.save(unite);
		Set<Unite> unites = new HashSet<>();
		unites.add(unite);
		
		Partie partie = new Partie();
		partieRepo.save(partie);
		Set<Partie> parties = new HashSet<>();
		parties.add(partie);
		
		Composition compo = new Composition(unites, parties, 0);
		compoRepo.save(compo);
		
		
		uniteRepo.save(unite);
		assertNotNull(unite.getId());
		
		List<Unite> opt = uniteRepo.findByComposition(compo);
		
	}
	*/
	
}

