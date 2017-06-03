package fr.formation.cocktailbar.entity;

import java.io.Serializable;

import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority, Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	@Override
	@Transient
	public String getAuthority() {
		return this.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
