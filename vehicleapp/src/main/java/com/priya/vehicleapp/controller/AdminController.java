package com.priya.vehicleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priya.vehicleapp.dto.LoginDTO;
import com.priya.vehicleapp.model.Admin;
import com.priya.vehicleapp.model.User;
import com.priya.vehicleapp.repository.UserRepository;
import com.priya.vehicleapp.service.AdminService;
import com.priya.vehicleapp.utilities.AdminConstants;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public String adminLogin(@RequestBody LoginDTO loginAdmin) {
		boolean isAvailable = adminService.loginAdmin(loginAdmin);
		if(isAvailable) {
			return AdminConstants.ADMIN_LOGGED_IN;
		}
		return AdminConstants.ADMIN_NOT_AVAILABLE;
	}
	
	@PostMapping("/register") 
	public String adminRegister(@RequestBody Admin admin) {
		Admin adminAdded = adminService.registerAdmin(admin);
		if(adminAdded == null) {
			return AdminConstants.ADMIN_EXISTS;
		}
		return AdminConstants.ADMIN_ADDED;
	}
	
	@GetMapping("/getUsers")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
