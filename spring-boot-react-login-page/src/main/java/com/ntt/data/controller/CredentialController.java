package com.ntt.data.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.data.model.LoginCredential;
import com.ntt.data.service.CredentialService;

@RestController
@RequestMapping(value="/api")
public class CredentialController {

	@Autowired
	private CredentialService credentialService;
	
	@PostMapping(value="/login")
	public ResponseEntity<?> login(@RequestBody LoginCredential loginCredential) {
		Optional<LoginCredential> reterivedCredential = credentialService.reteriveCredential(loginCredential.getUsername());
		String msg = null;
		if (reterivedCredential.isPresent()) {
			if(reterivedCredential.get().getPassword().equals(loginCredential.getPassword())) {
				msg = "Hello : " + reterivedCredential.get().getUsername();
			}else {
				msg = "Incorrect Password";
			}
		} else {
			msg = "User not found.";
		}
		return ResponseEntity.ok(msg);
	}
}
