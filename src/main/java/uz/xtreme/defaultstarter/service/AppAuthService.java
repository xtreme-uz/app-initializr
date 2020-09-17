package uz.xtreme.defaultstarter.service;

import org.springframework.http.ResponseEntity;

import uz.xtreme.defaultstarter.model.DataResponse;
import uz.xtreme.defaultstarter.model.auth.AuthenticationRequest;

public interface AppAuthService {

	ResponseEntity<DataResponse> authentication(AuthenticationRequest request);

}