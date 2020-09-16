package uz.xtreme.defaultstarter.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity {

	@Column(nullable = false)
	private String roleName;

	private String roleInfo;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "role_permission", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
	private Collection<Permission> permissions;

	@ManyToMany(mappedBy = "roles")
	private Collection<AuthUser> users;

	public Role(String roleName, String roleInfo, Collection<Permission> permissions) {
		super();
		this.roleName = roleName;
		this.roleInfo = roleInfo;
		this.permissions = permissions;
	}

}
