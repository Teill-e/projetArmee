package armee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import armee.entities.Armee;
import armee.exceptions.ArmeeException;
import armee.repositories.ArmeeRepository;
import armee.repositories.UniteRepository;

@Service
public class ArmeeService {
	
	@Autowired
	private ArmeeRepository armeeRepo;
	
	@Autowired
	private UniteRepository uniteRepo;
	
	private void checkArmee(Armee armee) {
		if (armee == null) {
			throw new ArmeeException("armee null");
		}
		if (armee.getPv() == null || armee.getMoral() == null || armee.getPays() == null) {
			throw new ArmeeException("informations manquantes");
		}
	}
	
	private void checkId(Long id) {
		if(id == null) {
			throw new ArmeeException("id null");
		}
	}
	
	public Armee getById(Long id) {
		checkId(id);
		return armeeRepo.findById(id).orElseThrow(() -> {
			throw new ArmeeException("id inconnu");
		});		
	}
	
	public Armee create(Armee armee) {
		checkArmee(armee);
		return armeeRepo.save(armee);
	}
	
	public Armee update(Armee armee) {
		Armee armeeEnBase = getById(armee.getId());
		checkArmee(armee);
		armeeEnBase.setPv(armee.getPv());
		armeeEnBase.setMoral(armee.getMoral());
		armeeEnBase.setPays(armee.getPays());
		armeeEnBase.setListeUnites(armee.getListeUnites());
		return armeeRepo.save(armeeEnBase);
	}
	
	public List<Armee> getAll(){
		return armeeRepo.findAll();
	}
	
	public void delete(Armee armee) {
		delete(armee.getId());
	}
	
	public void delete(Long id) {
		Armee ArmeeEnBase = getById(id);
		uniteRepo.deleteByArmee(ArmeeEnBase);
		armeeRepo.delete(ArmeeEnBase);
	}
}