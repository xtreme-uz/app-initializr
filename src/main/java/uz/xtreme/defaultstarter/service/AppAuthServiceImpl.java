package uz.xtreme.defaultstarter.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import uz.xtreme.defaultstarter.model.DataResponse;
import uz.xtreme.defaultstarter.model.auth.AuthenticationRequest;
import uz.xtreme.defaultstarter.model.auth.AuthenticationResponse;
import uz.xtreme.defaultstarter.util.JwtUtil;

@Service
public class AppAuthServiceImpl implements AppAuthService {

	private final AuthenticationManager authenticationManager;
	private final CustomUserDetailsService userDetailsService;
	private final JwtUtil jwtUtil;

	public AppAuthServiceImpl(AuthenticationManager authenticationManager,
			CustomUserDetailsService userDetailsService, JwtUtil jwtUtil) {
		super();
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public ResponseEntity<DataResponse> authentication(AuthenticationRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new DataResponse(new AuthenticationResponse(jwt)));
	}

}
