package uz.xtreme.defaultstarter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import uz.xtreme.defaultstarter.filter.JwtRequestFilter;

@EnableWebSecurity
public class SecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userService; 
	private final JwtRequestFilter jwtRequestFilter;

	public SecurityConfigurerAdapter(JwtRequestFilter jwtRequestFilter, UserDetailsService userService) {
		super();
		this.userService = userService;
		this.jwtRequestFilter = jwtRequestFilter;
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return userService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().antMatcher("/**").authorizeRequests()
				.antMatchers("/", "/api/v1.0/registration", "/api/v1.0/token").permitAll().anyRequest().authenticated()
				.and().exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.cors().and().addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod(HttpMethod.GET);
		config.addAllowedMethod(HttpMethod.HEAD);
		config.addAllowedMethod(HttpMethod.POST);
		config.addAllowedMethod(HttpMethod.PUT);
		config.addAllowedMethod(HttpMethod.PATCH);
		config.addAllowedMethod(HttpMethod.DELETE);
		config.addAllowedMethod(HttpMethod.OPTIONS);
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}
