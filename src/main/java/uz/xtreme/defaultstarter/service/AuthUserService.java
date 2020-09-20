package uz.xtreme.defaultstarter.service;

import uz.xtreme.defaultstarter.entity.AuthUser;

public interface AuthUserService extends AbstractService<AuthUser> {

	AuthUser save(AuthUser entity);

	boolean isUsernameExist(String username);

}
