package uz.xtreme.defaultstarter.service.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import uz.xtreme.defaultstarter.entity.AuthUser;
import uz.xtreme.defaultstarter.model.user.AuthUserDetail;
import uz.xtreme.defaultstarter.repository.AuthUserRepository;
import uz.xtreme.defaultstarter.service.GenericAbstractService;

@Service(value = "userService")
public class AuthUserServiceImpl extends GenericAbstractService<AuthUser, AuthUserRepository> implements AuthUserService, UserDetailsService {
	
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
		return super.save(entity);
	}
	
	@Override
	@PreAuthorize("hasRole(T(uz.xtreme.defaultstarter.util.Permission).USER_DELETE.name())")
	public void deleteById(long id) {
		super.deleteById(id);
	}

	@Override
	public boolean isUsernameExist(String username) {
		return repository.existsByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AuthUser> user = repository.findByUsername(username);
		if (user.isPresent())
			return new AuthUserDetail(user.get());
		else
			throw new UsernameNotFoundException("USER_NOT_FOUND");
	}

}
