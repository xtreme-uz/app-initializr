package uz.xtreme.defaultstarter.service.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import uz.xtreme.defaultstarter.entity.AuthUser;
import uz.xtreme.defaultstarter.exception.UsernamePasswordException;
import uz.xtreme.defaultstarter.model.DataResponse;
import uz.xtreme.defaultstarter.model.auth.AuthenticationRequest;
import uz.xtreme.defaultstarter.model.auth.AuthenticationResponse;
import uz.xtreme.defaultstarter.model.auth.RegistrationRequest;
import uz.xtreme.defaultstarter.service.CustomUserDetailsService;
import uz.xtreme.defaultstarter.util.JwtUtil;

@Service
public class AppAuthServiceImpl implements AppAuthService {

	private final AuthenticationManager authenticationManager;
	private final CustomUserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	private final AuthUserService authUserService;
	private final JwtUtil jwtUtil;

	public AppAuthServiceImpl(AuthenticationManager authenticationManager,
			CustomUserDetailsService userDetailsService, PasswordEncoder passwordEncoder, 
			AuthUserService authUserService, JwtUtil jwtUtil) {
		super();
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
		this.authUserService = authUserService;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public ResponseEntity<DataResponse> authentication(AuthenticationRequest request) {
		try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new UsernamePasswordException("INCORRECT_USERNAME_OR_PASSWORD");
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new DataResponse(new AuthenticationResponse(jwt)));
	}
	
	@Override
	public ResponseEntity<DataResponse> registration(RegistrationRequest request) {
		if (!authUserService.isUsernameExist(request.getUsername())) {
			authUserService.save(new AuthUser(request.getUsername(), passwordEncoder.encode(request.getPassword())));
			return ResponseEntity.ok(new DataResponse(true, "USER_CREATED"));
		}
		return ResponseEntity.ok(new DataResponse(false, "USERNAME_EXIST"));
	}

}
