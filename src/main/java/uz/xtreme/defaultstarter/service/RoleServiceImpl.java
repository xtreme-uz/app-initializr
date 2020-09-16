package uz.xtreme.defaultstarter.service;

import org.springframework.stereotype.Service;

import uz.xtreme.defaultstarter.entity.Role;
import uz.xtreme.defaultstarter.repository.RoleRepository;

@Service
public class RoleServiceImpl extends GenericAbstractService<Role, RoleRepository> implements RoleService {

	public RoleServiceImpl(RoleRepository repository) {
		super(repository);
	}

}
