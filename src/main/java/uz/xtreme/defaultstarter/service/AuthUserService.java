package uz.xtreme.defaultstarter.service;

import java.util.List;

import uz.xtreme.defaultstarter.entity.AuthUser;

public interface AuthUserService {

	AuthUser getById(long id);

	List<AuthUser> getAll();

	AuthUser save(AuthUser entity);

}
