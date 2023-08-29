package com.priya.vehicleapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priya.vehicleapp.dto.LoginDTO;
import com.priya.vehicleapp.model.Admin;
import com.priya.vehicleapp.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public boolean loginAdmin(LoginDTO loginAdmin) {
		Admin admin = adminRepository.findByAdminEmail(loginAdmin.getEmailId());
		if(admin == null || !admin.getPassword().equals(loginAdmin.getPassword()))
			return false;
		return true;
	}

	@Override
	public Admin registerAdmin(Admin admin) {
		Admin findAdmin = adminRepository.findByAdminEmail(admin.getAdminEmail());
		if(findAdmin != null)
			return null;
		Admin adminInsert = adminRepository.save(admin);
		return adminInsert;
	}

}
