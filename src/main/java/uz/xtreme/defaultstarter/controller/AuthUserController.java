package uz.xtreme.defaultstarter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uz.xtreme.defaultstarter.entity.AuthUser;
import uz.xtreme.defaultstarter.model.DataResponse;
import uz.xtreme.defaultstarter.service.AuthUserService;

@RestController
@RequestMapping("/api/v1.0/users")
public class AuthUserController extends AbstractController<AuthUser, AuthUserService> {

	public AuthUserController(AuthUserService service) {
		super(service);
	}

	@GetMapping
	public ResponseEntity<DataResponse> getAll() {
		return wrapResponse("users", service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DataResponse> get(@PathVariable long id) {
		return wrapResponse("user", service.getById(id));
	}

}
