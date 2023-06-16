package com.footballmatch.service;
import java.util.List;
import java.util.Set;

import com.footballmatch.entity.User;
import com.footballmatch.entity.UserRole;

public interface UserService {
	public User createUser(User user, Set<UserRole> userRoles) throws Exception ;
	public User getUser(String  username);
	public void deleteUser(Long userId);
	public List<User> getAllUsers();
	public User updateUser(User user);
}
