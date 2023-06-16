package com.footballmatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.footballmatch.service.UserService;

@SpringBootApplication
public class FootballMatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FootballMatchApplication.class, args);
	}
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		/*User user=new User();
		user.setUsername("bspadhy1999");
		user.setPassword(this.bCryptPasswordEncoder.encode("123456"));
		
		Role role1=new Role();
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");
		
		Set<UserRole> userRoleSet=new HashSet<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		
		userRoleSet.add(userRole);
		
		User user1=this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername()); */
	}

}
