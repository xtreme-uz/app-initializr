package uz.xtreme.defaultstarter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uz.xtreme.defaultstarter.entity.Permission;
import uz.xtreme.defaultstarter.model.DataResponse;
import uz.xtreme.defaultstarter.service.auth.PermissionService;

@RestController
@RequestMapping("/api/v1.0/permissions")
public class PermissionController extends AbstractController<Permission, PermissionService> {
	
	public PermissionController(PermissionService service) {
		super(service);
	}

	@GetMapping
	public ResponseEntity<DataResponse> getAll() {
		return wrapResponse("permissions", service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DataResponse> get(@PathVariable long id) {
		return wrapResponse("permission", service.getById(id));
	}
	
}
