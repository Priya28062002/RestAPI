package com.priya.vehicleapp.service;

import com.priya.vehicleapp.dto.LoginDTO;
import com.priya.vehicleapp.model.Admin;

public interface AdminService {
	
	public boolean loginAdmin(LoginDTO loginAdmin);
	
	public Admin registerAdmin(Admin admin);

}
