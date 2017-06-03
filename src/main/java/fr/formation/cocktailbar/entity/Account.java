package fr.formation.cocktailbar.entity;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Transient;

import org.springframework.security.core.userdetails.UserDetails;

public class Account implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;

	private String password;

	private Boolean enabled;

	private Role role;

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	@Transient
	public Collection<Role> getAuthorities() {
		return Arrays.asList(this.role);
	}

	@Override
	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
