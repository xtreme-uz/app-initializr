package uz.xtreme.defaultstarter.service;

import java.util.List;

import uz.xtreme.defaultstarter.entity.Permission;

public interface PermissionService {

	List<Permission> getAll();

	Permission get(long id);

}
