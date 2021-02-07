package com.ntt.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.data.model.LoginCredential;

public interface CredentialRepo extends JpaRepository<LoginCredential, String>{

}
