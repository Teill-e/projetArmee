package armee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import armee.entities.Admin;
import armee.exceptions.AdminException;
import armee.repositories.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepo;
	
	private void checkAdmin(Admin admin) {
		if (admin == null) {
			throw new AdminException("admin null");
		}
		if (admin.getLogin() == null || admin.getPassword().isEmpty()) {
			throw new AdminException("identifiants obligatoires");
		}
	}
	
	private void checkId(Long id) {
		if(id == null) {
			throw new AdminException("id null");
		}
	}
	
	public Admin getById(Long id) {
		checkId(id);
		return adminRepo.findById(id).orElseThrow(() -> {
			throw new AdminException("id inconnu");
		});		
	}
	
	public Admin create(Admin admin) {
		checkAdmin(admin);
		return adminRepo.save(admin);
	}
	
	public Admin update(Admin admin) {
		Admin adminEnBase = getById(admin.getId());
		checkAdmin(admin);
		adminEnBase.setLogin(admin.getLogin());
		adminEnBase.setPassword(admin.getPassword());
		return adminRepo.save(adminEnBase);
	}
	
	public List<Admin> getAll(){
		return adminRepo.findAll();
	}
	
	public void delete(Admin admin) {
		adminRepo.delete(admin);
	}
}
