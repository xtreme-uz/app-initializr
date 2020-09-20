package uz.xtreme.defaultstarter.configuration;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		if ((authentication == null) || !(permission instanceof String)) {
			return false;
		}
		return hasAuthority(authentication, ((String) permission).toUpperCase());
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		if ((authentication == null) || (targetType == null) || !(permission instanceof String)) {
			return false;
		}
		return hasAuthority(authentication, ((String) permission).toUpperCase());
	}

	private boolean hasAuthority(Authentication authentication, String permission) {
		return authentication.getAuthorities().stream().anyMatch(t -> t.getAuthority().equals(permission));
	}

}