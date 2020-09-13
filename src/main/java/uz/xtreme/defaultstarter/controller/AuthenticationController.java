package uz.xtreme.defaultstarter.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uz.xtreme.defaultstarter.model.DataResponse;
import uz.xtreme.defaultstarter.model.auth.AuthenticationRequest;
import uz.xtreme.defaultstarter.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1.0")
public class AuthenticationController {

	private final AuthenticationService service;
	
    public AuthenticationController(AuthenticationService service) {
		super();
		this.service = service;
	}

	@RequestMapping(value = "/token", method = POST)
    public ResponseEntity<DataResponse> createAuthenticationToken(@RequestBody AuthenticationRequest request) {
        return service.authentication(request);
    }
	
}
