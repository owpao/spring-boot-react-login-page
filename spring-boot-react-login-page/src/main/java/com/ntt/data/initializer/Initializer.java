package com.ntt.data.initializer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ntt.data.model.LoginCredential;
import com.ntt.data.service.CredentialService;

@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	private CredentialService credentialService;

	@Override
	public void run(String... args) throws Exception {
		LoginCredential credential = new LoginCredential();
		credential.setUsername("rkrawat0018@gmail.com");
		credential.setPassword("123@rk");
		credentialService.saveCredential(credential);

		Optional<LoginCredential> reterivedCredential = credentialService.reteriveCredential("rkrawat0018@gmail.com");
		if (reterivedCredential.isPresent()) {
			System.out.println("Username : " + reterivedCredential.get().getUsername() + ", " + "Password : "
					+ reterivedCredential.get().getPassword());
		} else {
			System.out.println("User not found.");
		}

	}

}
