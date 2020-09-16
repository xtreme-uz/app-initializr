package uz.xtreme.defaultstarter.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import uz.xtreme.defaultstarter.entity.AuthUser;
import uz.xtreme.defaultstarter.model.user.AuthUserDetail;
import uz.xtreme.defaultstarter.repository.AuthUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final AuthUserRepository repository;

	public CustomUserDetailsService(AuthUserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String s) {
		Optional<AuthUser> user = repository.findByUsername(s);
		if (user.isPresent())
			return new AuthUserDetail(user.get());
		else
			throw new UsernameNotFoundException("USER_NOT_FOUND");
	}

}
