package com.footballmatch.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballmatch.entity.User;
import com.footballmatch.entity.UserRole;
import com.footballmatch.repo.RoleRepo;
import com.footballmatch.repo.UserRepo;
import com.footballmatch.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local=this.userRepo.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println("User is already there !!");
			throw new Exception("User already present !!");
		}
		else {
			for(UserRole ur:userRoles) {
				roleRepo.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local=this.userRepo.save(user);
			
		}
		return local;
	}
	
	@Override
	public User getUser(String username) {
		return this.userRepo.findByUsername(username);
	}
	
	@Override
	public void deleteUser(Long userId) {
		this.userRepo.deleteById(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User updateUser(User user) {
		userRepo.save(user);
		return user;
	}
	
}
