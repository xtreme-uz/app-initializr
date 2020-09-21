package uz.xtreme.defaultstarter.service.auth;

import org.springframework.http.ResponseEntity;

import uz.xtreme.defaultstarter.model.DataResponse;
import uz.xtreme.defaultstarter.model.auth.AuthenticationRequest;
import uz.xtreme.defaultstarter.model.auth.RegistrationRequest;

public interface AppAuthService {

	ResponseEntity<DataResponse> authentication(AuthenticationRequest request);

	ResponseEntity<DataResponse> registration(RegistrationRequest request);

}
