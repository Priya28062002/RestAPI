package com.priya.vehicleapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priya.vehicleapp.dto.LoginDTO;
import com.priya.vehicleapp.model.User;
import com.priya.vehicleapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean userLogin(LoginDTO loginUser) {
		User user = userRepository.findByUserEmail(loginUser.getEmailId());
		if (user == null || !user.getPassword().equals(loginUser.getPassword()))
			return false;
		return true;
	}

	@Override
	public User userRegister(User user) {
		User findUser = userRepository.findByUserEmail(user.getUserEmail());
		if (findUser != null)
			return null;
		User userInsert = userRepository.save(user);
		return userInsert;
	}

}
