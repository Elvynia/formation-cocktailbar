package fr.formation.cocktailbar.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import fr.formation.cocktailbar.dao.RoleDao;
import fr.formation.cocktailbar.entity.Role;

public class RoleConverter implements Converter<String, Role> {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public Role convert(String source) {
		return this.roleDao.findOne(Integer.parseInt(source));
	}

}
