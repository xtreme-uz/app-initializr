package uz.xtreme.defaultstarter.service;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import uz.xtreme.defaultstarter.entity.AuthUser;
import uz.xtreme.defaultstarter.model.DataResponse;
import uz.xtreme.defaultstarter.model.auth.AuthenticationRequest;
import uz.xtreme.defaultstarter.model.auth.AuthenticationResponse;
import uz.xtreme.defaultstarter.repository.AuthUserRepository;
import uz.xtreme.defaultstarter.util.JwtUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService  userDetailsService;
    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil  jwtUtil;
    
	public AuthenticationServiceImpl(AuthenticationManager authenticationManager,
			CustomUserDetailsService userDetailsService, AuthUserRepository authUserRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
		super();
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.authUserRepository = authUserRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}
	
	@PostConstruct
	public void init() {
		AuthUser user = new AuthUser("foo", passwordEncoder.encode("foo"));
		authUserRepository.save(user);
	}

	@Override
	public ResponseEntity<DataResponse> authentication(AuthenticationRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new DataResponse(new AuthenticationResponse(jwt)));
	}
	
}
