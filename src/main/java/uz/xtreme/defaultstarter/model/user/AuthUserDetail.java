package uz.xtreme.defaultstarter.model.user;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import uz.xtreme.defaultstarter.entity.AuthUser;

@Getter
@Setter
public class AuthUserDetail implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	public AuthUserDetail(AuthUser user) {
		super();
		this.username = user.getUsername();
		this.password = user.getPassword();
	}

}
