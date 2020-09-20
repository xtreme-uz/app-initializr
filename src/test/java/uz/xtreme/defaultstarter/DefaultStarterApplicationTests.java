package uz.xtreme.defaultstarter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import uz.xtreme.defaultstarter.controller.AuthUserController;
import uz.xtreme.defaultstarter.controller.AuthenticationController;
import uz.xtreme.defaultstarter.controller.PermissionController;
import uz.xtreme.defaultstarter.controller.RoleController;

@SpringBootTest
class DefaultStarterApplicationTests {

	@Autowired
	private AuthenticationController authenticationController;
	
	@Autowired
	private AuthUserController authUserController;
	
	@Autowired
	private RoleController roleController;
	
	@Autowired
	private PermissionController permissionController;
	
	@Test
	void contextLoads() {
		assertThat(authenticationController).isNotNull();
		assertThat(authUserController).isNotNull();
		assertThat(roleController).isNotNull();
		assertThat(permissionController).isNotNull();
	}

}
