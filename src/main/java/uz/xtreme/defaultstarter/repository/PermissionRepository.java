package uz.xtreme.defaultstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.xtreme.defaultstarter.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
