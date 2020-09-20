package uz.xtreme.defaultstarter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.xtreme.defaultstarter.entity.AuthUser;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
	Optional<AuthUser> findByUsername(String username);
	boolean existsByUsername(String username);
}
