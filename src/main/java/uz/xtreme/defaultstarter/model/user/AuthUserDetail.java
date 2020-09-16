package uz.xtreme.defaultstarter.model.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import uz.xtreme.defaultstarter.entity.AuthUser;

@Getter
@Setter
public class AuthUserDetail implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Set<GrantedAuthority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public AuthUserDetail(AuthUser user) {
		super();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.authorities = collectAuthorities(user);
	}

	private Set<GrantedAuthority> collectAuthorities(AuthUser user) {
		Set<GrantedAuthority> authoritySet = new HashSet<>();
		user.getRoles().forEach(role -> {
			authoritySet.add(new SimpleGrantedAuthority(role.getRoleName()));
			role.getPermissions().forEach(permission -> {
				authoritySet.add(new SimpleGrantedAuthority(permission.getPermissionName()));
			});
		});
		return authoritySet;
	}

}
