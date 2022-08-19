package com.smm.android.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smm.android.dao.UserRepository;
import com.smm.android.enitites.User;

@Component
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		List<User> userList = (List<User>) userRepository.findAll();
		return userList;
	}

	public User getSingleUserById(int id) {
		User user = null;
		try {
			user = userRepository.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public User addUser(User usr) {
		User user = userRepository.save(usr);
		return user;
	}

	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	public void updateUser(User user, int userId) {
		user.setId(userId);
		userRepository.save(user);
	}
}
