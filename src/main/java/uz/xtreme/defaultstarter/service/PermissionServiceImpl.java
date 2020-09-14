package uz.xtreme.defaultstarter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import uz.xtreme.defaultstarter.entity.Permission;
import uz.xtreme.defaultstarter.repository.PermissionRepository;

@Service
public class PermissionServiceImpl implements PermissionService {

	private final PermissionRepository repository;

	public PermissionServiceImpl(PermissionRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public List<Permission> getAll() {
		return repository.findAll();
	}
	
	@Override
	public Permission get(long id) {
		Optional<Permission> entity = repository.findById(id);
		if (entity.isPresent())
			return entity.get();
		else
			throw new RuntimeException("PERMISSION_NOT_FOUND");
		
	}
	
	
	
}
