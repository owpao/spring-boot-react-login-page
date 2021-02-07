package com.ntt.data.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.data.model.LoginCredential;
import com.ntt.data.repository.CredentialRepo;

@Service
public class CredentialService {
	
	@Autowired
	private CredentialRepo credentialRepo;

	public String saveCredential(LoginCredential credential) {
		LoginCredential savedCredential = credentialRepo.save(credential);
		if(savedCredential !=null) {
			return "Credential saved!!!";
		}
		else {
			return "Database is not working.";
		}
	}
	
	public Optional<LoginCredential> reteriveCredential(String username) {
		return credentialRepo.findById(username);
	}
}
