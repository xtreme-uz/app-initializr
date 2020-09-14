package uz.xtreme.defaultstarter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import uz.xtreme.defaultstarter.entity.Role;
import uz.xtreme.defaultstarter.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	private final RoleRepository repository;

	public RoleServiceImpl(RoleRepository repository) {
		super();
		this.repository = repository;
	}
	
	public List<Role> getAll() {
		return repository.findAll();
	}
	
	
	public Role getOne(long id) {
		Optional<Role> entity = repository.findById(id);
		if(entity.isPresent()) 
			return entity.get();
		else
			throw new RuntimeException("ROLE_NOT_FOUND");
	}

}
