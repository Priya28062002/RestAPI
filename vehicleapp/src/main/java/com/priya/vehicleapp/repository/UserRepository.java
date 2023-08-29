package com.priya.vehicleapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.priya.vehicleapp.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserEmail(String userEmail);
    
}
