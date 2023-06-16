package com.footballmatch.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.footballmatch.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}
