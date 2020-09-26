package uz.xtreme.defaultstarter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uz.xtreme.defaultstarter.model.DataResponse;
import uz.xtreme.defaultstarter.model.auth.AuthenticationRequest;
import uz.xtreme.defaultstarter.model.auth.RegistrationRequest;
import uz.xtreme.defaultstarter.service.auth.AppAuthService;

@RestController
@RequestMapping("/api/v1.0")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {

	private final AppAuthService service;
	
    public AuthenticationController(AppAuthService service) {
		super();
		this.service = service;
	}

	@PostMapping(value = "/token")
    public ResponseEntity<DataResponse> createAuthenticationToken(@RequestBody AuthenticationRequest request) {
        return service.authentication(request);
    }
	
	@PostMapping(value = "/registration")
	public ResponseEntity<DataResponse> registration(@RequestBody RegistrationRequest request) {
		return service.registration(request);
	}
	
}
