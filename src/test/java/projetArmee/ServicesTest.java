package projetArmee;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import armee.config.JPAconfig;
import armee.entities.Admin;
import armee.entities.Arme;
import armee.entities.Armee;
import armee.entities.ArmeeAir;
import armee.entities.Composition;
import armee.entities.Joueur;
import armee.entities.Partie;
import armee.entities.Pays;
import armee.entities.TypeA;
import armee.entities.Unite;
import armee.services.AdminService;
import armee.services.ArmeService;
import armee.services.ArmeeService;
import armee.services.CompositionService;
import armee.services.JoueurService;
import armee.services.PartieService;
import armee.services.UniteService;

@SpringJUnitConfig(JPAconfig.class)
public class ServicesTest {

	@Autowired
	AdminService adminSrv;
	
	@Autowired
	ArmeeService armeeSrv;
	
	@Autowired
	ArmeService armeSrv;
	
	@Autowired
	JoueurService joueurSrv;
	
	@Autowired
	PartieService partieSrv;
	
	@Autowired
	CompositionService compoSrv;
	
	@Autowired
	UniteService uniteSrv;
	
//	@Test
//	void testJoueur() {
//		Joueur joueur = new Joueur("b", "123");
//		Joueur j2 = new Joueur("c","456");
//		
//		joueurSrv.create(joueur);
//		joueurSrv.create(j2);
//		
//		
//		List<Joueur> opt = joueurSrv.getAll();
//		
//		for (Joueur j : opt) {
//			System.out.println(j.getLogin());
//				}
//		
//	}
	
	@Test
	void testPartie() {
		Joueur joueur = new Joueur("b", "123");
		joueurSrv.create(joueur);
		
		Partie p1 = new Partie(LocalDate.now(), false, joueur, null, null);
		partieSrv.create(p1);
		Set<Partie> parties = new HashSet<>();
		parties.add(p1);
		
		Set<Arme> armes = new HashSet<>();
		Arme a1 = new Arme(TypeA.couteau);
		armeSrv.create(a1);
		armes.add(a1);
		
		Armee army = new ArmeeAir(100, Pays.Australie);
		armeeSrv.create(army);
		
		Unite u1 = new Unite(armes, 50, army);
		uniteSrv.create(u1);
		Set<Unite> unites = new HashSet<>();
		unites.add(u1);
		
		
		Composition compo = new Composition(unites, parties, 50);
		compoSrv.create(compo);
		
		//compoSrv.delete(compo);
		
		armeeSrv.delete(army);
		
		
		
		
	}
	
}
