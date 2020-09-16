package uz.xtreme.defaultstarter.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Permission extends BaseEntity {

	@Column(nullable = false)
	private String permissionName;

	private String permissionInfo;

	@ManyToMany(mappedBy = "permissions")
	private Collection<Role> roles;

	public Permission(String permissionName, String permissionInfo) {
		super();
		this.permissionName = permissionName;
		this.permissionInfo = permissionInfo;
	}

}
