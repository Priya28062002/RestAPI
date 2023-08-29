package com.priya.vehicleapp.service;

import com.priya.vehicleapp.dto.LoginDTO;
import com.priya.vehicleapp.model.User;

public interface UserService {

	public boolean userLogin(LoginDTO loginUser);

	public User userRegister(User user);

}
