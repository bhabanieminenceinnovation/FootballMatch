package com.footballmatch.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.footballmatch.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{

}
