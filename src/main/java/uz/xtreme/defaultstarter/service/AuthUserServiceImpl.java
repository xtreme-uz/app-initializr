package uz.xtreme.defaultstarter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import uz.xtreme.defaultstarter.entity.AuthUser;
import uz.xtreme.defaultstarter.repository.AuthUserRepository;

@Service
public class AuthUserServiceImpl implements AuthUserService {
	
	private final AuthUserRepository repository;
	
	public AuthUserServiceImpl(AuthUserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public AuthUser getById(long id) {
		Optional<AuthUser> entity = repository.findById(id);
		if (entity.isPresent())
			return entity.get();
		else
			throw new RuntimeException("USER_NOT_FOUND");
	}
	
	@Override
	@PreAuthorize("hasRole(T(uz.xtreme.defaultstarter.util.Permission).USER_READ)")
	public List<AuthUser> getAll() {
		return repository.findAll();
	}
	
	@Override
	@PreAuthorize("hasRole(T(uz.xtreme.defaultstarter.util.Permission).USER_CREATE)")
	public AuthUser save(AuthUser entity) {
		return repository.save(entity);
	}

}
