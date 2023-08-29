package com.priya.vehicleapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priya.vehicleapp.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByAdminEmail(String userEmail);

}
