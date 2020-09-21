package uz.xtreme.defaultstarter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uz.xtreme.defaultstarter.entity.Role;
import uz.xtreme.defaultstarter.model.DataResponse;
import uz.xtreme.defaultstarter.service.auth.RoleService;

@RestController
@RequestMapping("/api/v1.0/roles")
public class RoleController extends AbstractController<Role, RoleService> {
	
	public RoleController(RoleService service) {
		super(service);
	}

	@GetMapping
	public ResponseEntity<DataResponse> getAll() {
		return wrapResponse("roles", service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DataResponse> get(@PathVariable long id) {
		return wrapResponse("role", service.getById(id));
	}

}
