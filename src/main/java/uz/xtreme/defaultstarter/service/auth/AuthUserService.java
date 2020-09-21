package uz.xtreme.defaultstarter.service.auth;

import uz.xtreme.defaultstarter.entity.AuthUser;
import uz.xtreme.defaultstarter.service.AbstractService;

public interface AuthUserService extends AbstractService<AuthUser> {

	boolean isUsernameExist(String username);

}
