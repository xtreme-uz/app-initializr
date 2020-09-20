package uz.xtreme.defaultstarter.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
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
public class AuthUser extends BaseEntity {

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;

	public AuthUser(String username, String password, List<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public AuthUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.roles = Collections.emptyList();
	}

}
