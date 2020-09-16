package uz.xtreme.defaultstarter.service;

import org.springframework.stereotype.Service;

import uz.xtreme.defaultstarter.entity.Permission;
import uz.xtreme.defaultstarter.repository.PermissionRepository;

@Service
public class PermissionServiceImpl extends GenericAbstractService<Permission, PermissionRepository> implements PermissionService {

	public PermissionServiceImpl(PermissionRepository repository) {
		super(repository);
	}
	
}
