package com.security.jwt.repo;

import com.security.jwt.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
