package uz.xtreme.defaultstarter.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import uz.xtreme.defaultstarter.entity.AuthUser;
import uz.xtreme.defaultstarter.repository.AuthUserRepository;

@Service
public class AuthUserServiceImpl extends GenericAbstractService<AuthUser, AuthUserRepository> implements AuthUserService {
	
	public AuthUserServiceImpl(AuthUserRepository repository) {
		super(repository);
	}
	
	@Override
	@PreAuthorize("hasRole(T(uz.xtreme.defaultstarter.util.Permission).USER_READ.name())")
	public AuthUser getById(long id) {
		return super.getById(id);
	}

	@Override
	@PreAuthorize("hasRole(T(uz.xtreme.defaultstarter.util.Permission).USER_READ.name())")
	public List<AuthUser> getAll() {
		return super.getAll();
	}

	@Override
	@PreAuthorize("hasRole(T(uz.xtreme.defaultstarter.util.Permission).USER_CREATE.name())")
	public AuthUser save(AuthUser entity) {
		return repository.save(entity);
	}
	
	@Override
	public boolean isUsernameExist(String username) {
		return repository.existsByUsername(username);
	}

}
