package com.bptn.repository;

import com.bptn.models.AuthenticationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationUserRepository extends JpaRepository<AuthenticationUser, String> {

    AuthenticationUser findAuthenticationUserByIdAndUserPassword(String id, String password);

    AuthenticationUser findAuthenticationUserById(String id);
}
